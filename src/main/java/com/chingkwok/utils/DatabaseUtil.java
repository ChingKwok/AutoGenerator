package com.chingkwok.utils;

import com.common.entity.Column;
import com.common.entity.Table;
import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DatabaseUtil {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String JDBC_PREFIX = "jdbc:mysql://";
    private static final String SQL = "SELECT * FROM ";// 数据库操作
    private static List<String> BASE_COLUMN;

    static {
        try {
            Class.forName(DRIVER);
            BASE_COLUMN = new ArrayList<>();
            BASE_COLUMN.addAll(Arrays.asList("deleter_user_id", "is_deleted",
                    "deletion_time", "creation_time",
                    "creator_user_id", "creator_user_name",
                    "last_modification_time", "last_modifier_user_id"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取数据库下的所有表名
     */
    public static List<String> getTableNames(String url, String username, String password) {
        try (
                Connection conn = DriverManager.getConnection(url, username, password)

        ) {
            List<String> tableNames = new ArrayList<>();
            ResultSet rs = null;
            try {
                //获取数据库的元数据
                DatabaseMetaData db = conn.getMetaData();
                //从元数据中获取到所有的表名
                rs = db.getTables(null, null, null, new String[]{"TABLE"});
                while (rs.next()) {
                    tableNames.add(rs.getString(3));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return tableNames;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * 获取表中字段的所有注释
     *
     * @param tableName
     * @return
     */
    public static List<String> getColumnComments(String url, String username, String password, String tableName) {
        try (
                Connection conn = DriverManager.getConnection(url, username, password)
        ) {
            List<String> columnTypes = new ArrayList<>();
            //与数据库的连接
            PreparedStatement pStemt = null;
            String tableSql = SQL + tableName;
            List<String> columnComments = new ArrayList<>();//列名注释集合
            ResultSet rs = null;
            try {
                pStemt = conn.prepareStatement(tableSql);
                rs = pStemt.executeQuery("show full columns from " + tableName);
                while (rs.next()) {
                    columnComments.add(rs.getString("Comment"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return columnComments;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 获取主键
     *
     * @param url
     * @param username
     * @param password
     * @param table
     * @return
     */
    public static List<String> getPrimaryKey(String url, String username, String password, String table) {
        try (
                Connection conn = DriverManager.getConnection(url, username, password)
        ) {
            String sql = "SHOW CREATE TABLE " + table;
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            Pattern pattern = Pattern.compile("PRIMARY KEY \\(\\`(.*)\\`\\)");
            Matcher matcher = null;
            while (rs.next()) {
                matcher = pattern.matcher(rs.getString(2));
            }
            matcher.find();
            String data = matcher.group();
            //过滤对于字符
            data = data.replaceAll("\\`|PRIMARY KEY \\(|\\)", "");
            //拆分字符
            String[] stringArr = data.split(",");
            return Arrays.asList(stringArr);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<String>();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<String>();
        }
    }

    /**
     * 获取所有表
     *
     * @return
     */
    public static List<Table> getAllTable(String url, String username, String password) {
        try (Connection conn = DriverManager.getConnection(url, username, password)
        ) {
            List<String> tableNames = getTableNames(url, username, password);
            List<Table> collect = tableNames.stream().map(v -> {
                Table table = new Table();
                table.setEntityName(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, v));
                table.setAlias(getAlias(v));
                ArrayList<Column> columns = new ArrayList<>();
                table.setTableName(v);
                List<String> columnComments = getColumnComments(url, username, password, v);
                List<String> primaryKey = getPrimaryKey(url, username, password, v);
                String tableSql = SQL + v;
                try {
                    PreparedStatement pStemt = conn.prepareStatement(tableSql);
                    ResultSetMetaData metaData = pStemt.getMetaData();
                    DatabaseMetaData databaseMetaData = conn.getMetaData();
                    int count = metaData.getColumnCount();
                    for (int i = 0; i < count; i++) {
                        Column column = new Column();
                        if (primaryKey.contains(metaData.getColumnName(i + 1))) {
                            column.setIsPrimary(Boolean.TRUE);
                        } else column.setIsPrimary(Boolean.FALSE);
                        column.setName(metaData.getColumnName(i + 1));
                        //DATETIME替换TIMESTAMP
                        if (metaData.getColumnTypeName(i + 1).equals("DATETIME")) {
                            column.setTypeName("TIMESTAMP");
                        } else {
                            column.setTypeName(metaData.getColumnTypeName(i + 1));
                        }
                        if (BASE_COLUMN.contains(column.getName())) {
                            column.setIsBase(Boolean.TRUE);
                        } else {
                            column.setIsBase(Boolean.FALSE);
                        }
                        column.setTypeCode(metaData.getColumnType(i + 1));
                        column.setComment(columnComments.get(i));
                        column.setProperty(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, metaData.getColumnName(i + 1)));
                        //sqlType to JavaType
                        column.setJavaType(SqlToJavaType.sqlTojavaHandle(column.getTypeCode()));
                        //set EntityName
                        columns.add(column);
                    }
                    List<String> columnSet = columns.stream().map(c -> c.getJavaType()).distinct().collect(Collectors.toList());
                    table.setColumnSet(columnSet);
                    table.setColumns(columns);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return table;
            }).collect(Collectors.toList());
            return collect;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 生成缩写
     *
     * @param tableName
     * @return
     */
    public static String getAlias(String tableName) {
        if (StringUtils.isBlank(tableName)) return "";
        String[] strings = tableName.split("_");
        if (strings.length == 1) {
            return strings[0].substring(0, 1).toLowerCase();
        } else {
            String result = "";
            for (int i = 1; i < strings.length; i++) {
                result += strings[i].substring(0, 1);
            }
            return result.toLowerCase();
        }
    }

    /**
     * 拼接jdbc连接url
     *
     * @param ip
     * @param port
     * @param database
     * @return
     */
    public static String getJdbcUrl(String ip, String port, String database) {
        return JDBC_PREFIX + ip + ":" + port + "/" + database;
    }
}
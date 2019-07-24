package com.chingkwok;


import com.chingkwok.utils.DatabaseUtil;
import com.common.entity.Table;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

/**
 * Created by guojingye on 2019/7/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilTest {

    @Test
    public void getTables() {
        String url = "jdbc:mysql://134.175.6.168:3306/auto_generator";
        String username ="root";
        String password = "a602b854-8218-4857-b22c-f733bcd52671";
        List<Table> allTable = DatabaseUtil.getAllTable(url, username, password);
        for (Table t : allTable
                ) {
            String tableName = t.getTableName();
            System.out.println(tableName);
        }
    }
}

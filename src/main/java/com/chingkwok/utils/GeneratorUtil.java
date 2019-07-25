package com.chingkwok.utils;


import com.chingkwok.bean.entity.Project;
import com.chingkwok.component.SnowflakeIdWorker;
import com.chingkwok.exception.AutoGeneratorException;
import com.chingkwok.exception.eum.AutoGeneratorExceptionEnum;
import com.common.entity.Table;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by guojingye on 2019/7/23
 */
public class GeneratorUtil {
    private static final String SEPARATOR = System.getProperty("file.separator");
    private SnowflakeIdWorker snowflakeIdWorker;
    private HashMap<String, String> entityTargetMap;
    private HashMap<String, String> modalTargetMap;
    private String templateUrl;
    private String targetFileName;
    private Project project;

    static {

    }

    private GeneratorUtil() {
    }

    public GeneratorUtil(String templateUrl, String targetFileName, Project project) {
        this.project = project;
        this.targetFileName = targetFileName;
        this.templateUrl = templateUrl;

        snowflakeIdWorker = new SnowflakeIdWorker();
        //初始化文件对应关系,父文件夹需在子文件夹之前put
        entityTargetMap = new HashMap<>();
        entityTargetMap.put("entity", SEPARATOR + "bean" + SEPARATOR + "entity" + SEPARATOR);
        entityTargetMap.put("dto", SEPARATOR + "bean" + SEPARATOR + "dto" + SEPARATOR);
        entityTargetMap.put("vo", SEPARATOR + "bean" + SEPARATOR + "vo" + SEPARATOR);
        entityTargetMap.put("mapper_xml", SEPARATOR + "mapper_xml" + SEPARATOR);
        entityTargetMap.put("mapper", SEPARATOR + "mapper" + SEPARATOR);
        entityTargetMap.put("service", SEPARATOR + "service" + SEPARATOR);
        entityTargetMap.put("serviceImpl", SEPARATOR + "service" + SEPARATOR + "Impl" + SEPARATOR);

        //初始化骨架文件对应关系
        modalTargetMap = new HashMap<>();
        modalTargetMap.put("controller", SEPARATOR + "controller" + SEPARATOR);
        modalTargetMap.put("common", SEPARATOR + "common" + SEPARATOR);
    }

    /**
     * 生成骨架文件
     */
    public void generateModal() {

    }

    /**
     * 生成实体类,mapper,service
     */
    public void generateEntity() {
        try {
            File currentFile = initFile(targetFileName);

            Configuration configuration = new Configuration();
            configuration.setDirectoryForTemplateLoading(new File(templateUrl));
            // 获取表结构
            String jdbcUrl = DatabaseUtil.getJdbcUrl(project.getIpAddress(), project.getPort(), project.getDatasourceName());
            List<Table> allTable = DatabaseUtil.getAllTable(jdbcUrl, project.getUsername(), project.getPassword());
//            加载模板
            HashMap<String, Template> templateMap = initTemplate(configuration);
            for (Table t : allTable
            ) {

                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("table", t);
                dataMap.put("project", project);

                File docFile = null;
                //创建entity
                String entityPath = currentFile.getCanonicalPath() + entityTargetMap.get("entity") + t.getEntityName() + ".java";
                process(entityPath, templateMap.get("entityTemplate"), dataMap);

                //创建mapper_xml
                String mapperPath = currentFile.getCanonicalPath() + entityTargetMap.get("mapper_xml") + t.getEntityName() + ".xml";
                process(mapperPath, templateMap.get("mapper_xmlTemplate"), dataMap);

                //创建searchBean
                String searchDtoPath = currentFile.getCanonicalPath() + entityTargetMap.get("dto") + t.getEntityName() + "SearchDTO.java";
                process(searchDtoPath, templateMap.get("searchDtoTemplate"), dataMap);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AutoGeneratorException e) {
            e.printStackTrace();
        }

    }

    /**
     * 创建模板目标文件
     *
     * @param path
     * @param template
     * @param dataMap
     */
    private void process(String path, Template template, Map dataMap) {
        File docFile = new File(path);
        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)))) {
            template.process(dataMap, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }


    /**
     * 项目根目录创建目标父文件夹，并返回生成的文件夹
     *
     * @param parentFileName
     * @return File
     * @throws AutoGeneratorException
     */
    private File initFile(String parentFileName) throws AutoGeneratorException {
        String dir = System.getProperty("user.dir");
        FileUtils.createFile(dir + SEPARATOR + parentFileName);
        long l = snowflakeIdWorker.nextId();
        String currentTargetFile = dir + SEPARATOR + parentFileName + SEPARATOR + l;
        FileUtils.createFile(currentTargetFile);
        Iterator<Map.Entry<String, String>> iterator = entityTargetMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            if (!FileUtils.createFile(currentTargetFile + next.getValue())) {
                throw new AutoGeneratorException(AutoGeneratorExceptionEnum.CREATE_FILE_FAILURE);
            }
        }
        return new File(currentTargetFile);
    }

    /**
     * 初始化模板
     *
     * @param configuration
     * @return
     * @throws TemplateNotFoundException
     * @throws IOException
     */
    private HashMap<String, Template> initTemplate(Configuration configuration) throws TemplateNotFoundException, IOException {
        HashMap<String, Template> templateMap = new HashMap<>();
        templateMap.put("mapper_xmlTemplate", configuration.getTemplate("mapper.ftl"));
        templateMap.put("entityTemplate", configuration.getTemplate("entity.ftl"));
        templateMap.put("searchDtoTemplate", configuration.getTemplate("searchDto.ftl"));
        return templateMap;
    }

}

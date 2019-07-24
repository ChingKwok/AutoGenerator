package com.chingkwok.autogenerator;

import com.chingkwok.bean.entity.Project;
import com.chingkwok.utils.ConvertUtils;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by guojingye on 2019/7/24
 */
public class Main {
    public static void main(String[] args) {
        Project project = new Project();
        project.setDatasourceName("db11");
        project.setIpAddress("124.11.1.1");
        Map<String, Object> stringObjectMap = ConvertUtils.convertMap(project);
        Iterator<Map.Entry<String, Object>> iterator = stringObjectMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            System.out.println(next.getKey()+":"+next.getValue());
        }
    }
}

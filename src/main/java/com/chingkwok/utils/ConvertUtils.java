package com.chingkwok.utils;

import com.chingkwok.utils.interfaceFun.FieldFunction;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanMap;

import java.util.*;

/**
 * Created by guojingye on 2019/7/24
 */
public class ConvertUtils {
    public static <S, T> T convert(S source, Class<T> tClass) {
        return convert(source, tClass, null);
    }

    public static <S, T> T convert(S source, Class<T> tClass, FieldFunction<T> f) {
        T t = BeanUtils.instantiate(tClass);
        BeanUtils.copyProperties(source, t);
        if (f != null) {
            f.fill(t);
        }
        return t;
    }


    public static <S, T> List<T> convertList(List<S> sources, Class<T> tClass) {
        return convertList(sources, tClass, null);
    }

    public static <S, T> List<T> convertList(List<S> sources, Class<T> tClass, FieldFunction<T> f) {
        List<T> tList = new ArrayList<>();
        sources.stream().forEach(v -> tList.add(convert(v, tClass, f)));
        return tList;
    }

    public static <S> Map<String, Object> convertMap(S source) {
        Map<String, Object> map = new HashMap();
        Map<?, ?> beanMap = BeanMap.create(source);
        Iterator<? extends Map.Entry<?, ?>> iterator = beanMap.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<?, ?> next = iterator.next();
            map.put(next.getKey().toString(),next.getValue());
        }
        return map;
    }
}

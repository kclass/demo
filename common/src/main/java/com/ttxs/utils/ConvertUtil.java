package com.ttxs.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.*;


/**
 * 转换工具类
 * @author qinxt
 * @date  2019-10-17
 */
public class ConvertUtil {
    private static final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    /**
     * 将List<Map<String,Object>>转换成List<Bean>
     * @param data
     * @param typeClass
     * @return
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static List<Object> mapsToBeans(List<Object> data, Class<Object> typeClass) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        List<Object> beans = new ArrayList<>();
        for (Object map : data) {
            Object bean =  gson.fromJson(gson.toJson(map),typeClass);
            beans.add(bean);
        }
        return beans;
    }


    /**
     * 将list<javabean>转换为List<Map>
     * @param beans
     * @return
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static List<Map<String, Object>> beansToMaps(List beans) throws NoSuchMethodException,
            SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
        for (Object bean : beans) {
            maps.add(beanToMap(bean));
        }
        return maps;
    }

    /**
     * 将Map转换为JavaBean
     * @param map
     * @param classType
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Object mapToBean(Map<String, Object> map, Class classType) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        String json = gson.toJson(map);
        return gson.fromJson(json,classType);
    }
    /**
     * 将JavaBean转换成Map
     * @param bean
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static Map beanToMap(Object bean) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String json = gson.toJson(bean);
        Type type = new TypeToken<HashMap>(){}.getType();
        return gson.fromJson(json,type);
    }
}

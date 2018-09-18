package com.twan.base.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JsonUtil {

    private static Gson gson = null;

    static {
        if (gson == null) {
            gson = new Gson();
        }
    }

    private JsonUtil() {
    }

    /**
     * 将对象转换成json格式
     *
     * @param ts
     * @return
     */
    public static String objectToJson(Object ts) {
        String jsonStr = null;
        if (gson != null) {
            jsonStr = gson.toJson(ts);
        }
        return jsonStr;
    }

    /**
     * 将json格式转换成list对象
     *
     * @param jsonStr
     * @return
     */
    public static List<?> jsonToList(String jsonStr) {
        List<?> objList = null;
        try {
            if (gson != null) {
                Type type = new TypeToken<List<?>>() {
                }.getType();
                objList = gson.fromJson(jsonStr, type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objList;
    }

    /**
     * @param json
     * @param type
     * @return
     */
    public static Object json2List(String json, Type type) {
        if (gson != null) {
            return gson.fromJson(json, type);
        }
        return null;
    }

    /**
     * 将json格式转换成map对象
     *
     * @param jsonStr
     * @return
     */
    public static Map<?, ?> jsonToMap(String jsonStr) {
        Map<?, ?> objMap = null;
        try {
            if (gson != null) {
                try {
                    Type type = new TypeToken<Map<?, ?>>() {
                    }.getType();
                    objMap = gson.fromJson(jsonStr, type);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objMap;
    }

    /**
     * 将json转换成bean对象
     *
     * @param jsonStr
     * @return
     */
    public static <T> T jsonToBean(String jsonStr, Class<T> cl) {
        T obj = null;
        if (gson != null) {
            obj = gson.fromJson(jsonStr, cl);
        }
        return obj;
    }


    /**
     * 根据
     *
     * @param jsonStr
     * @param key
     * @return
     */
    public static Object getJsonValue(String jsonStr, String key) {
        Object rulsObj = null;
        Map<?, ?> rulsMap = jsonToMap(jsonStr);
        if (rulsMap != null && rulsMap.size() > 0) {
            rulsObj = rulsMap.get(key);
        }
        return rulsObj;
    }

    /**
     * 将json字符串转为list
     *
     * @param s
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> stringToArray(String s, Class<T[]> clazz) {
        if (TextUtils.isEmpty(s)) {
            return null;
        }
        T[] arr = new Gson().fromJson(s, clazz);

        return new ArrayList<>(Arrays.asList(arr));
    }
}

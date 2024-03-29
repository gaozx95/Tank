package com.gaozx.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    static Properties props = new Properties();
    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object get(String key){
        if(props == null) return null;
        return props.get(key);
    }
    public static int getInt(String key){
        if(props == null) return -1;
        return Integer.parseInt((String)props.get(key));
    }
}

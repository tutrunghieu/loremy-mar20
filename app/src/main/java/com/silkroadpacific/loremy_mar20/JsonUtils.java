package com.silkroadpacific.loremy_mar20;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Administrator on 3/20/2017.
 */
public class JsonUtils {
    public static ObjectMapper jm = new ObjectMapper();

    public static DefaultMapper objectFromString(String s) throws Exception
    {
        return jm.readValue(s, DefaultMapper.class);
    }
}

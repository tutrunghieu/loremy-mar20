package com.silkroadpacific.loremy_mar20;

import java.util.LinkedHashMap;

/**
 * Created by Administrator on 3/20/2017.
 */
public class DefaultMapper
{
    public int error;
    public String message;
    public Object data;
    public Object debug;

    @Override
    public String toString() {
        return "DefaultMapper{" +
                "error=" + error +
                ", message='" + message + '\'' +
                ", data=" + data.getClass() +
                ", debug=" + debug.getClass() +
                '}';
    }
}

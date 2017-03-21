package com.silkroadpacific.loremy.fragments;

import android.app.Fragment;
import android.view.View;

import com.silkroadpacific.loremy.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Andy on 3/21/2017.
 */

public class BaseFragment {
    public static void bindId(Object ik, View parent) {
        Class<?> clazz = parent.getClass();
        for(Field fk: ik.getClass().getFields()) {
            try {
                Method mk = clazz.getMethod("findViewById", int.class);
                int id = (int) R.id.class.getField(fk.getName()).get(parent);
                View vk = (View) mk.invoke(parent, id);
                fk.set(ik, vk);
            } catch (Exception e) {

            }
        }
    }
}

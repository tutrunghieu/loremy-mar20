package com.silkroadpacific.loremy.gui.common;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by Administrator on 4/5/2017.
 */

public class GUI
{
    public static void msg(String s, Activity act)
    {
        Toast.makeText(act, s, Toast.LENGTH_SHORT).show();
    }

}

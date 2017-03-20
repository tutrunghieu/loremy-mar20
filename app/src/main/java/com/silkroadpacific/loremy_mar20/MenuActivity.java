package com.silkroadpacific.loremy_mar20;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.JsonReader;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.silkroadpacific.loremy_mar20.physical.BackendAccess;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MenuActivity extends __BaseActivity
{
    protected void setSpecificLayout() {
        setContentView(R.layout.activity_menu);
    }

    public static  void main(String[] args) throws Exception
    {
        String uk = "http://103.200.20.217:8080/lausac/api/post/index";
//        readJson(uk);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(uk).build();
        Response response = client.newCall(request).execute();

        ResponseBody body = response.body();
        String s = body.string();
        body.close();

        System.out.println("parsing " + s);
        DefaultMapper obj = JsonUtils.objectFromString(s);
        System.out.println(obj);

        Map<String, Object> data = (Map<String, Object>)obj.data;

        for(String nk: data.keySet() )
        {
            System.out.println(nk + ":");
        }
    }

    private static List<String> toList(Iterator<String> iter)
    {
        List<String> copy = new ArrayList<String>();
        while (iter.hasNext()) copy.add(iter.next());
        return copy;
    }

    private static String readJson(String uk) throws Exception
    {
        URL u = new URL(uk);
        InputStream rd = u.openStream();

        BufferedReader r = new BufferedReader(new InputStreamReader(rd));
        System.out.println("Thu xem the nao");

        StringBuilder res = new StringBuilder();

        int k=0;
        while(true)
        {
            String lk = r.readLine();
            if(lk==null) break;
            System.out.println("line " + k + ": " + lk);
            res.append(lk);

            k++;
        }

        rd.close();

        return res.toString();
    }
}

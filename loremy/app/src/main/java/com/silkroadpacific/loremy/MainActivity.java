package com.silkroadpacific.loremy;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.silkroadpacific.loremy.fragments.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Toolbar toolbarHome;
    private FrameLayout content;

    private MenuFragment menuFragment;
    private OrderFragment orderFragment;
    private OutletFragment outletFragment;
    private PostFragment postFragment;
    private UserFragment userFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener onItemSelected
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        Fragment frag = null;
        Map<String, String> params = new HashMap<>();
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_menu:
                    getSupportActionBar().setTitle(R.string.nav_menu);
                    frag = MenuFragment.newInstance(params);
                    return true;
                case R.id.nav_order:
                    getSupportActionBar().setTitle(R.string.nav_order);
                    frag = OrderFragment.newInstance(params);
                    return true;
                case R.id.nav_outlet:
                    getSupportActionBar().setTitle(R.string.nav_outlet);
                    frag = PostFragment.newInstance(params);
                    return true;
                case R.id.nav_post:
                    getSupportActionBar().setTitle(R.string.nav_post);
                    frag = MenuFragment.newInstance(params);
                    return true;
                case R.id.nav_profile:
                    getSupportActionBar().setTitle(R.string.nav_profile);
                    frag = MenuFragment.newInstance(params);
                    return true;
            }

            if (frag != null) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.add(R.id.container, frag, frag.getTag());
                ft.commit();
            }

            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarHome = (Toolbar) findViewById(R.id.toolbarHome);
        content = (FrameLayout) findViewById(R.id.content);

        prepareActionBar(toolbarHome);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(onItemSelected);
    }

    public void prepareActionBar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        }
    }

    public void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }

}

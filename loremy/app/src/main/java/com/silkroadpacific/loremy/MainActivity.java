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

import com.silkroadpacific.loremy.fragments.MenuFragment;
import com.silkroadpacific.loremy.fragments.OrderFragment;
import com.silkroadpacific.loremy.fragments.OutletFragment;
import com.silkroadpacific.loremy.fragments.PostFragment;
import com.silkroadpacific.loremy.fragments.UserFragment;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String SELECTED_ITEM = "arg_selected_item";
    private Toolbar toolbarHome;
    private BottomNavigationView navigation;
    private int mSelectedItem;

    private BottomNavigationView.OnNavigationItemSelectedListener onItemSelected
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            selectFragment(item);
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarHome = (Toolbar) findViewById(R.id.toolbarHome);

        prepareActionBar(toolbarHome);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(onItemSelected);

        MenuItem selectedItem;
        if (savedInstanceState != null) {
            mSelectedItem = savedInstanceState.getInt(SELECTED_ITEM, 0);
            selectedItem = navigation.getMenu().findItem(mSelectedItem);
        } else {
            selectedItem = navigation.getMenu().getItem(0);
        }
        selectFragment(selectedItem);
    }

    public void prepareActionBar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    @Override
    public void onBackPressed() {
        MenuItem homeItem = navigation.getMenu().getItem(0);
        if (mSelectedItem != homeItem.getItemId()) {
            selectFragment(homeItem);
        } else {
            super.onBackPressed();
        }
    }

    private void selectFragment(MenuItem item) {
        Fragment frag = null;
        Map<String, String> params = new HashMap<>();

        switch (item.getItemId()) {
            case R.id.nav_menu:
                getSupportActionBar().setTitle(R.string.nav_menu);
                frag = MenuFragment.newInstance(params);
                break;
            case R.id.nav_order:
                getSupportActionBar().setTitle(R.string.nav_order);
                frag = OrderFragment.newInstance(params);
                break;
            case R.id.nav_outlet:
                getSupportActionBar().setTitle(R.string.nav_outlet);
                frag = OutletFragment.newInstance(params);
                break;
            case R.id.nav_post:
                getSupportActionBar().setTitle(R.string.nav_post);
                frag = PostFragment.newInstance(params);
                break;
            case R.id.nav_profile:
                getSupportActionBar().setTitle(R.string.nav_profile);
                frag = UserFragment.newInstance(params);
                break;
            default:
                getSupportActionBar().setTitle(R.string.nav_menu);
                frag = MenuFragment.newInstance(params);
                break;
        }

        for (int i = 0; i < navigation.getMenu().size(); i++) {
            MenuItem menuItem = navigation.getMenu().getItem(i);
            menuItem.setChecked(menuItem.getItemId() == item.getItemId());
        }

        if (frag != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.content, frag, frag.getTag());
            ft.commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
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

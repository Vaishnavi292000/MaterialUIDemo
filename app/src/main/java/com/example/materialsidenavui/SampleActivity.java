package com.example.materialsidenavui;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialsidenavui.fragment.CenteredTextFragment;
import com.example.materialsidenavui.menu.DrawerAdapter;

import com.example.materialsidenavui.model.DashboardMenu;
import com.example.materialsidenavui.uicustomlibrary.SlidingRootNav;
import com.example.materialsidenavui.uicustomlibrary.SlidingRootNavBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yarolegovich on 25.03.2017.
 */

public class SampleActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener {

    List<DashboardMenu> dashboardMenuList =new ArrayList<>();
    private SlidingRootNav slidingRootNav;
    TextView tvTabName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        tvTabName = findViewById(R.id.tvTabName);

        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();

        DashboardMenu dashboardMenu = new DashboardMenu();
        dashboardMenu.setMenuName("Account");
        dashboardMenu.setChecked(true);
        dashboardMenu.setIcon(R.drawable.library);
        dashboardMenuList.add(dashboardMenu);

        DashboardMenu atttendacne = new DashboardMenu();
        atttendacne.setMenuName("Attendance");
        atttendacne.setIcon(R.drawable.library);
        dashboardMenuList.add(atttendacne);

        DrawerAdapter adapter = new DrawerAdapter(dashboardMenuList);
        adapter.setListener(this);

        RecyclerView list = findViewById(R.id.list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(0);
    }

    @Override
    public void onItemSelected(int position) {
        DashboardMenu menu = dashboardMenuList.get(position);
        slidingRootNav.closeMenu();
        tvTabName.setText(menu.getMenuName());
        Fragment selectedScreen = null;
        selectedScreen = CenteredTextFragment.createFor(menu.getMenuName());

        showFragment(selectedScreen);
    }


    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }
}

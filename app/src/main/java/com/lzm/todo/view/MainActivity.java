package com.lzm.todo.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.lzm.todo.R;
import com.lzm.todo.adapter.MainFragmentAdapter;
import com.lzm.todo.constant.Priority;
import com.lzm.todo.view.calendarview.view.CalendarFragment;
import com.lzm.todo.view.searchtodoview.SearchTodoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseFragmentActivity {

    private Fragment calendarFragment;
    private Fragment searchFragment;
    private List<Fragment> fragmentList;

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private BottomNavigationView navigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0, false);
                    return true;
                case R.id.navigation_message:
                    mViewPager.setCurrentItem(1, false);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void initView() {
        navigationView = findViewById(R.id.nav_main);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initPage();
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initPage() {
        fragmentList = new ArrayList<>();
        calendarFragment = new CalendarFragment();
        searchFragment = new SearchTodoFragment();
        fragmentList.add(calendarFragment);
        fragmentList.add(searchFragment);

        mViewPager = findViewById(R.id.vp_main);
        mPagerAdapter = new MainFragmentAdapter(getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(mPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                navigationView.getMenu().getItem(i).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    public void hideBar(){
        navigationView.setVisibility(View.GONE);
    }

    public void showBar(){
        navigationView.setVisibility(View.VISIBLE);
    }
}

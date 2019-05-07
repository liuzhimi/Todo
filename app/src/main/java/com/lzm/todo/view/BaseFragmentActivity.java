package com.lzm.todo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * @author liuzhimi
 * @date 2019/5/6
 */
public abstract class BaseFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected abstract void initView();

    protected abstract void initDate();

    protected abstract void initPage();

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        //checkSession();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}

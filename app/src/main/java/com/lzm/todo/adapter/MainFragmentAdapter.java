package com.lzm.todo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

public class MainFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public MainFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
        //return StringConstant.MAIN_PAGE_NUM;
    }

    /**
     * 重写该方法，取消调用父类该方法
     * 可以避免在viewpager切换，fragment不可见时执行到onDestroyView，可见时又从onCreateView重新加载视图
     * 因为父类的destroyItem方法中会调用detach方法，将fragment与view分离，（detach()->onPause()->onStop()->onDestroyView()）
     * 然后在instantiateItem方法中又调用attach方法，此方法里判断如果fragment与view分离了，
     * 那就重新执行onCreateView，再次将view与fragment绑定（attach()->onCreateView()->onActivityCreated()->onStart()->onResume()）
     * */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }

}

package com.lzm.todo.view.calendarview.model;

import android.content.Context;

import com.lzm.todo.dao.TodoDao;
import com.lzm.todo.view.calendarview.presenter.ICalendarCallBack;

/**
 * @author liuzhimi
 * @date 2019/5/7
 */
public class CalendarModel implements ICalendarModel {

    private Context context;
    private TodoDao dao;

    public CalendarModel(Context context) {
        this.context = context;
        dao = new TodoDao(context);
    }

    @Override
    public void getData(long time, ICalendarCallBack callBack) {
        callBack.success(dao.getByDay(time));
    }
}

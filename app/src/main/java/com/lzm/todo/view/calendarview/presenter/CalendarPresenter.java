package com.lzm.todo.view.calendarview.presenter;

import android.content.Context;
import android.util.Log;

import com.lzm.todo.entity.Todo;
import com.lzm.todo.view.calendarview.model.CalendarModel;
import com.lzm.todo.view.calendarview.model.ICalendarModel;
import com.lzm.todo.view.calendarview.view.ICalendarView;

import java.util.List;

/**
 * @author liuzhimi
 * @date 2019/5/7
 */
public class CalendarPresenter implements ICalendarPresenter, ICalendarCallBack {

    private ICalendarView view;
    private ICalendarModel model;
    private Context context;

    public CalendarPresenter(ICalendarView view, Context context) {
        this.view = view;
        this.model = new CalendarModel(context);
        this.context = context;
    }

    @Override
    public void success(List<Todo> todoList) {
        Log.d("xxxx", "success: " + todoList);
        view.showData(todoList);

    }

    @Override
    public void failure(Throwable t) {

    }

    @Override
    public void loadData(long time) {
        model.getData(time, this);
    }
}

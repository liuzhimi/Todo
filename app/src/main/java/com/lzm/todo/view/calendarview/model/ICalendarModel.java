package com.lzm.todo.view.calendarview.model;

import com.lzm.todo.dao.TodoDao;
import com.lzm.todo.entity.Todo;
import com.lzm.todo.view.calendarview.presenter.ICalendarCallBack;

/**
 * @author liuzhimi
 * @date 2019/5/7
 */
public interface ICalendarModel {

    void getData(long time, ICalendarCallBack callBack);
}

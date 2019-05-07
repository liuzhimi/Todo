package com.lzm.todo.view.calendarview.presenter;

import com.lzm.todo.entity.Todo;

import java.util.List;

/**
 * @author liuzhimi
 * @date 2019/5/7
 */
public interface ICalendarCallBack {

    void success(List<Todo> todoList);

    void failure(Throwable t);
}

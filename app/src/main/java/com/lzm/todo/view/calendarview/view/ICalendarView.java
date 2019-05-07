package com.lzm.todo.view.calendarview.view;

import com.lzm.todo.entity.Todo;

import java.util.List;

/**
 * @author liuzhimi
 * @date 2019/5/6
 */
public interface ICalendarView {

    void showData(List<Todo> todoList);
}

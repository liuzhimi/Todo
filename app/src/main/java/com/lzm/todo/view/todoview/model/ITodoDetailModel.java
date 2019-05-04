package com.lzm.todo.view.todoview.model;

import com.lzm.todo.entity.Todo;
import com.lzm.todo.view.todoview.presenter.ITodoDetailCallBack;

/**
 * @author liuzhimi
 * @date 2019/5/4
 */
public interface ITodoDetailModel {

    void saveTodo(ITodoDetailCallBack callBack, Todo todo);
}

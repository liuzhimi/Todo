package com.lzm.todo.view.todoview.model;

import com.lzm.todo.dao.TodoDao;
import com.lzm.todo.entity.Todo;
import com.lzm.todo.view.todoview.presenter.ITodoDetailCallBack;

/**
 * @author liuzhimi
 * @date 2019/5/4
 */
public class TodoDetailModel implements ITodoDetailModel{

    private TodoDao dao;

    public TodoDetailModel() {
        //TODO: 初始化dao
    }

    @Override
    public void saveTodo(ITodoDetailCallBack callBack, Todo todo) {

    }
}

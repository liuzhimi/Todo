package com.lzm.todo.view.todoview.model;

import android.content.Context;

import com.lzm.todo.dao.TodoDao;
import com.lzm.todo.entity.Todo;
import com.lzm.todo.view.todoview.presenter.ITodoDetailCallBack;

/**
 * @author liuzhimi
 * @date 2019/5/4
 */
public class TodoDetailModel implements ITodoDetailModel{

    private TodoDao dao;
    private Context context;

    public TodoDetailModel(Context context) {
        this.context = context;
        dao = new TodoDao(context);
    }

    @Override
    public void saveTodo(ITodoDetailCallBack callBack, Todo todo) {
        dao.insert(todo);
    }
}

package com.lzm.todo.view.todoview.presenter;

import android.content.Context;

import com.lzm.todo.entity.Todo;
import com.lzm.todo.view.todoview.model.ITodoDetailModel;
import com.lzm.todo.view.todoview.view.ITodoDetailView;

/**
 * @author liuzhimi
 * @date 2019/5/4
 */
public class TodoDetailPresenter implements ITodoDetailPresenter, ITodoDetailCallBack {

    private ITodoDetailView view;
    private ITodoDetailModel model;
    private Context context;

    public TodoDetailPresenter(ITodoDetailView view, ITodoDetailModel model, Context context) {
        this.view = view;
        this.model = model;
        this.context = context;
    }

    @Override
    public void saveTodo(Todo todo) {

    }

    @Override
    public void success(int status) {
        view.showSaveResult();
    }

    @Override
    public void failure(Throwable t) {

    }

}

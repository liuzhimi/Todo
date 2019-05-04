package com.lzm.todo.view.todoview.presenter;

/**
 * @author liuzhimi
 * @date 2019/5/4
 */
public interface ITodoDetailCallBack {

    void success(int status);

    void failure(Throwable t);
}

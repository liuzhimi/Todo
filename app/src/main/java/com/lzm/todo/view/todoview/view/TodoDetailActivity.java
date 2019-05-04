package com.lzm.todo.view.todoview.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lzm.todo.R;
import com.lzm.todo.entity.Todo;
import com.lzm.todo.view.todoview.presenter.ITodoDetailPresenter;

public class TodoDetailActivity extends AppCompatActivity implements ITodoDetailView, View.OnClickListener{

    private ITodoDetailPresenter presenter;
    private Todo todo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);
    }

    private void saveTodo(){
        presenter.saveTodo(todo);
    }

    @Override
    public void showSaveResult() {

    }

    @Override
    public void onClick(View v) {

    }
}

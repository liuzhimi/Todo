package com.lzm.todo.view.todoview.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.lzm.todo.R;
import com.lzm.todo.entity.Todo;
import com.lzm.todo.view.todoview.presenter.ITodoDetailPresenter;
import com.lzm.todo.view.todoview.presenter.TodoDetailPresenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoDetailActivity extends AppCompatActivity implements ITodoDetailView, View.OnClickListener{

    private ITodoDetailPresenter presenter;
    private Todo todo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);
        initData();
    }

    //Todo:实例化各种变量
    private void initView(){

    }

    private void initData()  {
        presenter = new TodoDetailPresenter(this, this);
        String s1 = "2019/05/07";
        String s2 = "2019/05/16";
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        long date = 0;
        try {
            date = format.parse(s1).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long date1 = 0;
        try {
            date1 = format.parse(s2).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.d("xxxx", "initData: " + date);
        todo = new Todo(1 ,"没事", date, date + 100, "哈哈哈哈哈", 0, date - 100);
        saveTodo();
        todo = new Todo(2 ,"没事", date1, date1 + 100, "哈哈哈哈哈", 1, date1 - 100);
        saveTodo();
    }

    private void saveTodo(){
        presenter.saveTodo(todo);
    }

    @Override
    public void showSaveResult() {
        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_save:
                saveTodo();
                break;
        }
    }
}

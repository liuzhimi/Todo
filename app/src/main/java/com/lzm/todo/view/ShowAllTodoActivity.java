package com.lzm.todo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.lzm.todo.R;
import com.lzm.todo.dao.TodoDao;
import com.lzm.todo.entity.Todo;

import java.util.List;

public class ShowAllTodoActivity extends AppCompatActivity {

    EditText selectTodo;
    ListView showTodo;
    TodoDao todoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_todo);
        selectTodo = (EditText)findViewById(R.id.selectTodo);
        showTodo = (ListView)findViewById(R.id.showTodo);
        List<Todo> result = todoDao.getAll();
    }

    public void searchTodo(View view) {
        String title = selectTodo.getText().toString();
        List<Todo> result = todoDao.getAllByTitle(title);
    }
}

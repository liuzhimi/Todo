package com.lzm.todo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.lzm.todo.R;
import com.lzm.todo.dao.TodoDao;
import com.lzm.todo.entity.Todo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        todoDao = new TodoDao(this);
        final List<Todo> result = todoDao.getAll();
        long nowTime = System.currentTimeMillis();
        final List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (Todo todo : result) {
            Map<String, Object> map = new HashMap<String, Object>();
            if (nowTime < todo.getStartTime())
                map.put("imgTip", R.drawable.dot_green);
            else if (nowTime >= todo.getStartTime() && nowTime < todo.getEndTime())
                map.put("imgTip", R.drawable.dot_yellow);
            else if (nowTime >= todo.getEndTime())
                map.put("imgTip", R.drawable.dot_red);
            map.put("todoThing", todo.getTitle());
            map.put("todoTime", transferLongToDate(todo.getStartTime()));
            listItems.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.simple_show_to, new String[] {"imgTip", "todoThing", "todoTime"}, new int[] {R.id.imgTip, R.id.todoThing, R.id.todoTime});
        showTodo.setAdapter(adapter);

        showTodo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //跳转链接 to HeYingte
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ShowAllTodoActivity.this, String.valueOf(result.get(i).getId()), Toast.LENGTH_SHORT);
            }
        });
    }

    public void searchTodo(View view) {
        showTodo.setAdapter(null);
        String title = selectTodo.getText().toString();

        final List<Todo> result;
        if (title.equals("")) {
            result = todoDao.getAll();
        } else {
            result = todoDao.getAllByTitle(title);
        }

        long nowTime = System.currentTimeMillis();
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        for (Todo todo : result) {
            Map<String, Object> map = new HashMap<String, Object>();
            if (nowTime < todo.getStartTime())
                map.put("imgTip", R.drawable.dot_green);
            else if (nowTime >= todo.getStartTime() && nowTime < todo.getEndTime())
                map.put("imgTip", R.drawable.dot_yellow);
            else if (nowTime >= todo.getEndTime())
                map.put("imgTip", R.drawable.dot_red);
            map.put("todoThing", todo.getTitle());
            map.put("todoTime", transferLongToDate(todo.getStartTime()));
            listItems.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.simple_show_to, new String[] {"imgTip", "todoThing", "todoTime"}, new int[] {R.id.imgTip, R.id.todoThing, R.id.todoTime});
        showTodo.setAdapter(adapter);

        showTodo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //跳转链接 to HeYingte
                Toast.makeText(ShowAllTodoActivity.this, String.valueOf(result.get(i).getId()), Toast.LENGTH_SHORT);
            }
        });
    }

    public String transferLongToDate(Long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(millSec);
        return sdf.format(date);
    }
}

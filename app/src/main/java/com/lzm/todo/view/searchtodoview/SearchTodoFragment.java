package com.lzm.todo.view.searchtodoview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.lzm.todo.R;
import com.lzm.todo.dao.TodoDao;
import com.lzm.todo.entity.Todo;
import com.lzm.todo.view.ShowAllTodoActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuhanbo
 * @date 2019/5/11
 */
public class SearchTodoFragment extends Fragment {

    EditText selectTodo;
    ListView showTodo;
    TodoDao todoDao;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_show_all_todo, container, false);
        selectTodo = (EditText)view.findViewById(R.id.selectTodo);
        showTodo = (ListView)view.findViewById(R.id.showTodo);
        todoDao = new TodoDao(view.getContext());
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
            String time = transferLongToDate(todo.getStartTime()) + "\n" + transferLongToDate(todo.getEndTime());
            map.put("todoTime", time);
            listItems.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(view.getContext(), listItems, R.layout.simple_show_to, new String[] {"imgTip", "todoThing", "todoTime"}, new int[] {R.id.imgTip, R.id.todoThing, R.id.todoTime});
        showTodo.setAdapter(adapter);

        showTodo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //跳转链接 to HeYingte
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(view.getContext(), String.valueOf(result.get(i).getId()), Toast.LENGTH_SHORT).show();
            }
        });

        selectTodo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                search(view);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;
    }

    public void search(View view) {
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
            String time = transferLongToDate(todo.getStartTime()) + "\n" + transferLongToDate(todo.getEndTime());
            map.put("todoTime", time);
            listItems.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(view.getContext(), listItems, R.layout.simple_show_to, new String[] {"imgTip", "todoThing", "todoTime"}, new int[] {R.id.imgTip, R.id.todoThing, R.id.todoTime});
        showTodo.setAdapter(adapter);

        showTodo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //跳转链接 to HeYingte
                Toast.makeText(view.getContext(), String.valueOf(result.get(i).getId()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String transferLongToDate(Long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(millSec);
        return sdf.format(date);
    }

}

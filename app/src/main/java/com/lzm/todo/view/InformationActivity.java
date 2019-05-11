package com.lzm.todo.view;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lzm.todo.R;
import com.lzm.todo.constant.Priority;
import com.lzm.todo.dao.TodoDao;
import com.lzm.todo.entity.Todo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 显示行程的详细信息，接收ToDo的id,根据id从数据库查询,并显示
 * 点击编辑按钮跳转到编辑界面
 * 点击删除，根据id从数据库删除，跳转到主界面
 */
public class InformationActivity extends AppCompatActivity {
    private ImageView img_edit;//编辑按钮
    private ImageView img_delete;//删除按钮
    private TextView tv_title;
    private TextView tv_start;
    private TextView tv_end;
    private TextView tv_alert;
    private TextView tv_level;
    private TextView tv_detail;
    private Todo todo;
    private Bundle b;
    private TodoDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        dao=new TodoDao(InformationActivity.this);
        tv_title=(TextView)findViewById(R.id.text_todo_title);
        tv_start=(TextView)findViewById(R.id.text_todo_start);
        tv_end=(TextView)findViewById(R.id.text_todo_end);
        tv_alert=(TextView)findViewById(R.id.text_todo_alert);
        tv_level=(TextView)findViewById(R.id.text_todo_level);
        tv_detail=(TextView)findViewById(R.id.text_todo_detail);
        b=this.getIntent().getExtras();
        todo=new Todo();
        todo.setId(b.getLong("todoid"));
        todo.setTitle(b.getString("todotitle"));
        todo.setStartTime(b.getLong("todostart"));
        todo.setEndTime(b.getLong("todoend"));
        todo.setFirstNoticeTime(b.getLong("todonotice"));
        todo.setPriority(b.getInt("todopriority"));
        todo.setContent(b.getString("todocontent"));


        tv_title.setText(todo.getTitle());
        tv_start.setText(String.valueOf(longToString(todo.getStartTime())));
        tv_end.setText(String.valueOf(longToString(todo.getEndTime())));
        tv_alert.setText(String.valueOf(longToString(todo.getFirstNoticeTime())));
        tv_level.setText(priorityToString(todo.getPriority()));
        tv_detail.setText(todo.getContent());

    }
    private String priorityToString(int i){
        String levelstr="";
        if(i==Priority.EASY){
            levelstr="不重要";
        }else if(i==Priority.NORMAL){
            levelstr="一般";
        }else{
            levelstr="重要";
        }
        return levelstr;
    }
    private String longToString(long l){
        SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.CHINA);
        Date date=new Date(l);
        return f.format(date);
    }
    protected void deleteclick(View v){
        //Toast.makeText(InformationActivity.this,"hello delete!",Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder=new AlertDialog.Builder(InformationActivity.this,R.style.buttonDialog);
        builder.setMessage("是否删除此活动？");
        //builder.setIcon(R.drawable.icon);

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(InformationActivity.this, "您点击了确定按钮", Toast.LENGTH_LONG).show();
                dao.delete(todo.getId());
                dialog.cancel();
                Intent goback=new Intent();
                setResult(101,goback);
                finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(InformationActivity.this, "您点击了取消按钮", Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });

        AlertDialog dialog=    builder.create();
        dialog.show();
    }
    protected void goback(View v){
        Intent i=new Intent();
        setResult(102,i);
        finish();
    }
}

package com.lzm.todo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User0 on 2019/5/3.
 */

public class TodoDao {
    private static TodoDBOpenHelper dbOpenHelper;

    public TodoDao(Context context) {
        if(dbOpenHelper != null)
            return;

        dbOpenHelper = new TodoDBOpenHelper(context, TodoDBOpenHelper.DB_NAME, null, 1);
        //检查并新建数据库
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.close();
    }

    //所有列表返回值均包含所有信息

    //获取所有行程
    public List<Todo> getAll(){

        List<Todo> result = new ArrayList<>();
        Todo item;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor c = db.query(TodoDBOpenHelper.TBL_NAME,null,null,null,null,null,"stime ASC");
        if(c.moveToFirst()){
            do{
                item = new Todo();
                item.setId(c.getLong(0));
                item.setTitle(c.getString(1));
                item.setStartTime(c.getLong(2));
                item.setEndTime(c.getLong(3));
                item.setContent(c.getString(4));
                item.setPriority(c.getInt(5));
                item.setFirstNoticeTime(c.getLong(6));

                result.add(item);
            }while(c.moveToNext());
        }
        db.close();
        return result;
    }
	
	 // 搜索所有行程
    public List<Todo> getAllByTitle(String title){

        List<Todo> result = new ArrayList<>();
        Todo item;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor c = db.query(TodoDBOpenHelper.TBL_NAME, null, "title like ?", new String[]{"%"+title+"%"},
                null, null, "stime ASC");
        if(c.moveToFirst()){
            do{
                item = new Todo();
                item.setId(c.getLong(0));
                item.setTitle(c.getString(1));
                item.setStartTime(c.getLong(2));
                item.setEndTime(c.getLong(3));
                item.setContent(c.getString(4));
                item.setPriority(c.getInt(5));
                item.setFirstNoticeTime(c.getLong(6));

                result.add(item);
            }while(c.moveToNext());
        }
        db.close();
        return result;
    }

    //获取参数确定的日期当天的行程
    public List<Todo> getByDay(long time){
        //1 day = 86400 seconds = 86'400'000 mili seconds
        long day = time - (time % 86400000);
        long nextDay = day + 86400000;

        List<Todo> result = new ArrayList<>();
        Todo item;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor c = db.query(TodoDBOpenHelper.TBL_NAME, null,
                "stime > ? and stime < ?",
                new String[]{String.valueOf(day), String.valueOf(nextDay)},
                null, null, "stime ASC");
        if(c.moveToFirst()){
            do{
                item = new Todo();
                item.setId(c.getLong(0));
                item.setTitle(c.getString(1));
                item.setStartTime(c.getLong(2));
                item.setEndTime(c.getLong(3));
                item.setContent(c.getString(4));
                item.setPriority(c.getInt(5));
                item.setFirstNoticeTime(c.getLong(6));

                result.add(item);
            }while(c.moveToNext());
        }
        db.close();
        return result;
    }

    //获取开始日期在参数日期之前的所有行程
    public List<Todo> getAllStartBeforeTime(long time){

        List<Todo> result = new ArrayList<>();
        Todo item;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor c = db.query(TodoDBOpenHelper.TBL_NAME,null,"stime < ?",new String[]{String.valueOf(time)},
                null,null,"stime ASC");
        if(c.moveToFirst()){
            do{
                item = new Todo();
                item.setId(c.getLong(0));
                item.setTitle(c.getString(1));
                item.setStartTime(c.getLong(2));
                item.setEndTime(c.getLong(3));
                item.setContent(c.getString(4));
                item.setPriority(c.getInt(5));
                item.setFirstNoticeTime(c.getLong(6));

                result.add(item);
            }while(c.moveToNext());
        }
        db.close();
        return result;
    }

    //获取开始日期在参数日期之后的所有行程
    public List<Todo> getAllStartAfterTime(long time){

        List<Todo> result = new ArrayList<>();
        Todo item;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor c = db.query(TodoDBOpenHelper.TBL_NAME,null,"stime > ?",new String[]{String.valueOf(time)},
                null,null,"stime ASC");
        if(c.moveToFirst()){
            do{
                item = new Todo();
                item.setId(c.getLong(0));
                item.setTitle(c.getString(1));
                item.setStartTime(c.getLong(2));
                item.setEndTime(c.getLong(3));
                item.setContent(c.getString(4));
                item.setPriority(c.getInt(5));
                item.setFirstNoticeTime(c.getLong(6));

                result.add(item);
            }while(c.moveToNext());
        }
        db.close();
        return result;
    }

    //获取参数确定的日期当天并且在参数时间已开始的行程
    public List<Todo> getDayStartBeforeTime(long time){
        //1 day = 86400 seconds = 86'400'000 mili seconds
        long day = time - (time % 86400000);

        List<Todo> result = new ArrayList<>();
        Todo item;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor c = db.query(TodoDBOpenHelper.TBL_NAME, null,
                "stime > ? and stime < ?",
                new String[]{String.valueOf(day), String.valueOf(time)},
                null, null, "stime ASC");
        if(c.moveToFirst()){
            do{
                item = new Todo();
                item.setId(c.getLong(0));
                item.setTitle(c.getString(1));
                item.setStartTime(c.getLong(2));
                item.setEndTime(c.getLong(3));
                item.setContent(c.getString(4));
                item.setPriority(c.getInt(5));
                item.setFirstNoticeTime(c.getLong(6));

                result.add(item);
            }while(c.moveToNext());
        }
        db.close();
        return result;
    }

    //获取参数确定的日期当天并且在参数时间未开始的行程
    public List<Todo> getDayStartAfterTime(long time){
        //1 day = 86400 seconds = 86'400'000 mili seconds
        long day = time - (time % 86400000) + 86400000;//nextday

        List<Todo> result = new ArrayList<>();
        Todo item;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor c = db.query(TodoDBOpenHelper.TBL_NAME, null,
                "stime > ? and stime < ?",
                new String[]{String.valueOf(time), String.valueOf(day)},
                null, null, "stime ASC");
        if(c.moveToFirst()){
            do{
                item = new Todo();
                item.setId(c.getLong(0));
                item.setTitle(c.getString(1));
                item.setStartTime(c.getLong(2));
                item.setEndTime(c.getLong(3));
                item.setContent(c.getString(4));
                item.setPriority(c.getInt(5));
                item.setFirstNoticeTime(c.getLong(6));

                result.add(item);
            }while(c.moveToNext());
        }
        db.close();
        return result;
    }

    //获取行程详细信息
    public Todo getTodoDetail(long id){

        Todo result = new Todo();
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor c = db.query(TodoDBOpenHelper.TBL_NAME, null,
                "id = ?",
                new String[]{String.valueOf(id)},
                null, null, null);
        if(c.moveToFirst()){
            do{
                result.setId(c.getLong(0));
                result.setTitle(c.getString(1));
                result.setStartTime(c.getLong(2));
                result.setEndTime(c.getLong(3));
                result.setContent(c.getString(4));
                result.setPriority(c.getInt(5));
                result.setFirstNoticeTime(c.getLong(6));
            }while(c.moveToNext());
        }
        db.close();
        return result;
    }
    //插入
    public void insert(Todo todo){
        ContentValues values = new ContentValues();
        values.put(TodoDBOpenHelper.FIELD_TITLE,todo.getTitle());
        values.put(TodoDBOpenHelper.FIELD_START_TIME, todo.getStartTime());
        values.put(TodoDBOpenHelper.FIELD_END_TIME, todo.getEndTime());
        values.put(TodoDBOpenHelper.FIELD_CONTENT, todo.getContent());
        values.put(TodoDBOpenHelper.FIELD_PRIORITY, todo.getPriority());
        values.put(TodoDBOpenHelper.FIELD_FIRST_NOTICE_TIME, todo.getFirstNoticeTime());

        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.insert(TodoDBOpenHelper.TBL_NAME,null,values);
        db.close();
    }
    //更新, 根据id
    public void update(Todo todo){
        ContentValues values = new ContentValues();
        values.put(TodoDBOpenHelper.FIELD_TITLE,todo.getTitle());
        values.put(TodoDBOpenHelper.FIELD_START_TIME, todo.getStartTime());
        values.put(TodoDBOpenHelper.FIELD_END_TIME, todo.getEndTime());
        values.put(TodoDBOpenHelper.FIELD_CONTENT, todo.getContent());
        values.put(TodoDBOpenHelper.FIELD_PRIORITY, todo.getPriority());
        values.put(TodoDBOpenHelper.FIELD_FIRST_NOTICE_TIME, todo.getFirstNoticeTime());

        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.update(TodoDBOpenHelper.TBL_NAME, values, "id = ?",
                new String[]{String.valueOf(todo.getId())});
        db.close();
    }
    //删除, 根据id
    public void delete(long id){
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.delete(TodoDBOpenHelper.TBL_NAME,"id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

}

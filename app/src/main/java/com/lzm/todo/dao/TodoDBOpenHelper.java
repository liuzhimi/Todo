package com.lzm.todo.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User0 on 2019/5/3.
 */

public class TodoDBOpenHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "todo.db";
    public static final String TBL_NAME = "todo_tbl";

    public static final String FIELD_ID = "id";                    //type: BIGINT/long index: 0
    public static final String FIELD_TITLE = "title";              //type: TEXT/String index: 1
    public static final String FIELD_START_TIME = "stime";         //type: BIGINT/long index: 2
    public static final String FIELD_END_TIME = "etime";           //type: BIGINT/long index: 3
    public static final String FIELD_CONTENT = "content";          //type: TEXT/String index: 4
    public static final String FIELD_PRIORITY = "priority";        //type: INTEGER/int index: 5
    public static final String FIELD_FIRST_NOTICE_TIME = "fntime"; //type: BIGINT/long index: 6

    private static final String CREATE_TABLE = "create table todo_tbl(" +
            "id integer primary key autoincrement," +
            " title text, stime bigint, etime bigint, content text, priority integer, fntime bigint)";


    public TodoDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

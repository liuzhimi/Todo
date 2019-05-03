package com.lzm.todo.dao;

/**
 * Created by User0 on 2019/5/3.
 */

public class Todo {

    private long id;
    private String title;
    private long startTime;
    private long endTime;
    private String content;
    private int priority; //0:easy, 1:normal, 2:important
    private long firstNoticeTime;

    public Todo(long id, String title, long startTime, long endTime, String content, int priority, long firstNoticeTime) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.content = content;
        this.priority = priority;
        this.firstNoticeTime = firstNoticeTime;
    }

    public Todo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public long getFirstNoticeTime() {
        return firstNoticeTime;
    }

    public void setFirstNoticeTime(long firstNoticeTime) {
        this.firstNoticeTime = firstNoticeTime;
    }
}

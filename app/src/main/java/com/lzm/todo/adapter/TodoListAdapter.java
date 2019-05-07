package com.lzm.todo.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzm.todo.R;
import com.lzm.todo.entity.Todo;
import com.lzm.todo.util.TimeUtils;

import java.util.List;

import static com.lzm.todo.util.DotDrawable.getDot;

/**
 * @author liuzhimi
 * @date 2019/5/7
 */
public class TodoListAdapter extends BaseQuickAdapter<Todo, BaseViewHolder> {
    public TodoListAdapter() {
        super(R.layout.todo_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, Todo item) {
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setImageResource(R.id.iv_dot, getDot(item.getPriority()));
        helper.setText(R.id.tv_start_time, TimeUtils.getHM(item.getStartTime()));
    }
}

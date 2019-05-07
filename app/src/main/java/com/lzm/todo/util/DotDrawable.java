package com.lzm.todo.util;

import com.lzm.todo.R;

/**
 * @author liuzhimi
 * @date 2019/5/7
 */
public class DotDrawable {

    public static int getDot(int priority){
        switch (priority){
            case 0:
                return R.drawable.dot_green;
            case 1:
                return R.drawable.dot_yellow;
            case 2:
                return R.drawable.dot_red;
        }
        return 0;
    }
}

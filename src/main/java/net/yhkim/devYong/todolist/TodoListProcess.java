package net.yhkim.devYong.todolist;

import java.util.HashMap;

/**
 * Created by yong on 2018. 6. 30..
 */
public interface TodoListProcess {

    String getBoardAllList(HashMap<String, Object> params) throws Exception;

    String boardCreate(HashMap<String, Object> params) throws Exception;

    String boardRead(HashMap<String, Object> params) throws Exception;

    String boardUpdate(HashMap<String, Object> params) throws Exception;

    String boardRelationList(HashMap<String, Object> params) throws Exception;
}

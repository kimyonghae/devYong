package net.yhkim.devYong.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by yong on 2018. 6. 30..
 */
@Service("todoListService")
@Repository
public class TodoListServiceImpl implements TodoListService {

    @Autowired
    TodoListProcess todoListProcess;

    public String getBoardAllList(HashMap<String, Object> params) throws Exception {
        return todoListProcess.getBoardAllList(params);
    }

    public String boardCreate(HashMap<String, Object> params) throws Exception {
        return todoListProcess.boardCreate(params);
    }

    public String boardRead(HashMap<String, Object> params) throws Exception {
        return todoListProcess.boardRead(params);
    }

    public String boardUpdate(HashMap<String, Object> params) throws Exception {
        return todoListProcess.boardUpdate(params);
    }

    public String boardRelationList(HashMap<String, Object> params) throws Exception {
        return todoListProcess.boardRelationList(params);
    }
}

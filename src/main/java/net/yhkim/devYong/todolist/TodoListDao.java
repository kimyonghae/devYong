package net.yhkim.devYong.todolist;

import net.yhkim.devYong.common.AbstractDAO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yong on 2018. 6. 30..
 */
@Repository
public class TodoListDao extends AbstractDAO{

    public List<Board> getBoardAllList(HashMap<String, Object> params) { return selectList("mapper.todolist.getBoardAllList", params); }

    public Object getTotalCount() { return selectOne("mapper.todolist.getTotalCount"); }

    public Object getMaxID() {
        return selectOne("mapper.todolist.getMaxID");
    }

    public void boardRelationCreate(BoardRelation boardRelation) {
        insert("mapper.todolist.boardRelationCreate", boardRelation);
    }

    public void boardCreate(HashMap<String, Object> params) {
        insert("mapper.todolist.boardCreate", params);
    }

    public Object boardRead(HashMap<String, Object> params) { return selectOne("mapper.todolist.boardRead", params); }

    public void boardUpdate(Board params) { update("mapper.todolist.boardUpdate", params); }

    public List<Board> boardRelationList() {
        return selectList("mapper.todolist.boardRelationList");
    }
}

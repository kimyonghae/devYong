package net.yhkim.devYong.todolist;

/**
 * Created by yong on 2018. 6. 30..
 */
public class BoardRelation {
    private Integer id;
    private Object boardId;
    private Integer relationId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getBoardId() {
        return boardId;
    }

    public void setBoardId(Object boardId) {
        this.boardId = boardId;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }
}

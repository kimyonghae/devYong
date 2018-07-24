package net.yhkim.devYong.todolist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yong on 2018. 6. 30..
 */
@Service("todoListProcess")
@Repository
public class TodoListProcessImpl implements TodoListProcess {

    @Autowired
    TodoListDao todoListDao;

    private ObjectMapper objectMapper = new ObjectMapper();

    public String getBoardAllList(HashMap<String, Object> params) throws Exception {
        String response;
        Map<String, Object> result = new HashMap<String, Object>();

        //paging
        int totalCount = 0;//전체글 수
        int pageCount = 0;//페이지 수
        int currentPage = 1;//현재 페이지
        int pageSize = 10;//페이지당 글 수
        int start = 1;//페이지 시작 글 번호

        try {
            currentPage = Integer.parseInt(params.get("currentPage").toString());
            pageSize = Integer.parseInt(params.get("pageSize").toString());
            if(currentPage>1){
                start = (currentPage-1) * pageSize + 1;
            }
            totalCount = Integer.parseInt(todoListDao.getTotalCount().toString());
            pageCount = totalCount/pageSize;
            if((totalCount%pageSize)>0){
                pageCount += 1;
            }

            Paging pagination = new Paging();
            pagination.setCurrentPage(currentPage);
            pagination.setPageSize(pageSize);
            pagination.setTotalCount(pageCount);

            params.put("start", start);
            params.put("pageSize", pageSize);

            result.put("result", "200");
            result.put("message", "SUCCESS");
            result.put("items", todoListDao.getBoardAllList(params));
            result.put("pagination", pagination);

            response = objectMapper.writeValueAsString(result);
        } catch (Exception e) {
            e.printStackTrace();

            result.put("result", "500");
            result.put("message", e.getMessage());
            result.put("items", new ArrayList());
            result.put("pagination", new Paging());

            response = objectMapper.writeValueAsString(result);
        }

        return response;
    }

    public String boardCreate(HashMap<String, Object> params) throws Exception{
        String response;
        Map<String, Object> result = new HashMap<String, Object>();
        BoardRelation boardRelation = new BoardRelation();
        Object creatId;

        try {
            creatId = todoListDao.getMaxID();
            params.put("id", creatId);
            todoListDao.boardCreate(params);

            if(!params.get("relationId").equals("")){
                String[] boardRel = params.get("relationId").toString().split(",");
                boardRelation.setBoardId(creatId);
                for(int i=0;i<boardRel.length;i++){
                    boardRelation.setRelationId(Integer.parseInt(boardRel[i].toString()));
                    todoListDao.boardRelationCreate(boardRelation);
                }
            }

            result.put("result", "200");
            result.put("message", "SUCCESS");

            response = objectMapper.writeValueAsString(result);
        } catch (Exception e) {
            e.printStackTrace();

            result.put("result", "500");
            result.put("message", e.getMessage());

            response = objectMapper.writeValueAsString(result);
        }

        return response;
    }

    public String boardRead(HashMap<String, Object> params) throws Exception {
        String response;
        Map<String, Object> result = new HashMap<String, Object>();

        try {
            result.put("result", "200");
            result.put("message", "SUCCESS");
            result.put("item", todoListDao.boardRead(params));

            response = objectMapper.writeValueAsString(result);
        } catch (Exception e) {
            e.printStackTrace();

            result.put("result", "500");
            result.put("message", e.getMessage());
            result.put("item", new HashMap<String,String>());

            response = objectMapper.writeValueAsString(result);
        }

        return response;
    }

    public String boardUpdate(HashMap<String, Object> params) throws Exception {
        String response;
        Map<String, Object> result = new HashMap<String, Object>();
        Board board = new Board();

        board.setId(Integer.parseInt(params.get("id").toString()));
        board.setWork(params.get("work").toString());
        if(params.get("procYn")!=null){
            if(params.get("procYn").toString().equals("on")){
                board.setProcYn(true);
            }else{
                board.setProcYn(false);// 실직적 무쓸모 상황 지워도됨
            }
        }

        try {
            todoListDao.boardUpdate(board);

            result.put("result", "200");
            result.put("message", "SUCCESS");

            response = objectMapper.writeValueAsString(result);
        } catch (Exception e) {
            e.printStackTrace();

            result.put("result", "500");
            result.put("message", e.getMessage());

            response = objectMapper.writeValueAsString(result);
        }

        return response;
    }

    public String boardRelationList(HashMap<String, Object> params) throws Exception {
        String response;
        Map<String, Object> result = new HashMap<String, Object>();

        try {
            result.put("result", "200");
            result.put("message", "SUCCESS");
            result.put("items", todoListDao.boardRelationList());

            response = objectMapper.writeValueAsString(result);
        } catch (Exception e) {
            e.printStackTrace();

            result.put("result", "500");
            result.put("message", e.getMessage());
            result.put("items", new ArrayList());

            response = objectMapper.writeValueAsString(result);
        }

        return response;
    }
}

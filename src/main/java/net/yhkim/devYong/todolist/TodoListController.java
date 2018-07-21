package net.yhkim.devYong.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * Created by yong on 2018. 6. 30..
 */
@Controller
public class TodoListController {

    @Autowired
    private TodoListService todoListService;

    @RequestMapping(value = "/boardMain")
    public ModelAndView todoListMain(){
        ModelAndView mav = new ModelAndView("todoList/boardListMain");
        return mav;
    }
    @RequestMapping(value = "/boardList", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf-8")
    public @ResponseBody String boardList(@RequestParam HashMap<String, Object> params) throws Exception {
        return todoListService.getBoardAllList(params);
    }


    @RequestMapping(value = "/boardCreatePage")
    public ModelAndView boardCreatePage(){
        ModelAndView mav = new ModelAndView("todoList/boardCreatePage");
        return mav;
    }
    @RequestMapping(value = "/boardCreate", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf-8")
    public @ResponseBody String boardCreate(@RequestParam HashMap<String, Object> params) throws Exception {
        return todoListService.boardCreate(params);
    }
    @RequestMapping(value = "/popBoardRelation")
    public ModelAndView popBoardRelation(){
        ModelAndView mav = new ModelAndView("todoList/popBoardRelation");
        return mav;
    }
    @RequestMapping(value = "/boardRelationList", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf-8")
    public @ResponseBody String boardRelationList(@RequestParam HashMap<String, Object> params) throws Exception {
        return todoListService.boardRelationList(params);
    }


    @RequestMapping(value = "/boardUpdatePage")
    public ModelAndView boardUpdatePage(){
        ModelAndView mav = new ModelAndView("todoList/boardUpdatePage");
        return mav;
    }
    @RequestMapping(value = "/boardRead", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf-8")
    public @ResponseBody String boardRead(@RequestParam HashMap<String, Object> params) throws Exception {
        return todoListService.boardRead(params);
    }
    @RequestMapping(value = "/boardUpdate", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf-8")
    public @ResponseBody String boardUpdate(@RequestParam HashMap<String, Object> params) throws Exception {
        return todoListService.boardUpdate(params);
    }


}

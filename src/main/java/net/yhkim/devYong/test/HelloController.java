package net.yhkim.devYong.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yong on 2018. 6. 23..
 */
@Controller
public class HelloController {

    @Autowired
    TestService testService;

    @RequestMapping("/")
    public ModelAndView hello(){

        ModelAndView mav = new ModelAndView("index");
        String dbConTest = testService.dbConTest();

        mav.addObject("msg", "hello ok?" + dbConTest);

        return mav;
    }
}

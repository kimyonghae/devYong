package net.yhkim.devYong.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yong on 2018. 6. 23..
 */
@Service("testProcess")
public class TestProcessImpl implements TestProcess{

    @Autowired
    TestDao testDao;

    public String dbConTest(){
        return testDao.dbConTest();
    }
}

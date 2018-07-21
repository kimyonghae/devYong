package net.yhkim.devYong.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yong on 2018. 6. 23..
 */
@Service("testService")
public class TestServiceImpl implements TestService{

    @Autowired
    private TestProcess testProcess;

    public String dbConTest() {
        return testProcess.dbConTest();
    }
}

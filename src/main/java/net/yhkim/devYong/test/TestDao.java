package net.yhkim.devYong.test;

import net.yhkim.devYong.common.AbstractDAO;
import org.springframework.stereotype.Repository;

/**
 * Created by yong on 2018. 6. 23..
 */
@Repository
public class TestDao extends AbstractDAO{

    public String dbConTest(){
        return (String) selectOne("mapper.test.dbConTest");
    }
}

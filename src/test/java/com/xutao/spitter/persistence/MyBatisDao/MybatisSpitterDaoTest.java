package com.xutao.spitter.persistence.MyBatisDao;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Tau_Hsu on 2016/10/17.
 */
public class MybatisSpitterDaoTest {

    @Test
    public void saveSpitterTableTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("persistence-context.xml");
        MybatisSpitterDao mybatisSpitterDao = (MybatisSpitterDao)ctx.getBean("mybatisSpitterDao");
        SpitterTable spitterTable = new SpitterTable();
        spitterTable.setUsername("TestMan");
        spitterTable.setPassword("12345678");
        spitterTable.setFullname("TestManFullName");
        spitterTable.setEmail("1111111111@email.com");
        spitterTable.setUpdate_by_email(1);
        mybatisSpitterDao.addSpitterTable(spitterTable);
    }
}

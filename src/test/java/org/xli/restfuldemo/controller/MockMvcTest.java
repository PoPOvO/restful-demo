package org.xli.restfuldemo.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author xli
 * @Description
 * @Date 创建于 2019/1/31 18:55
 */
//@RunWith就是一个运行器，这里表明使用Spring环境的测试
@RunWith(SpringRunner.class)
//帮忙设置Spring Boot的默认配置
@SpringBootTest
public class MockMvcTest {
    protected MockMvc mockMvc;
    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Before
    public void before() {
        //获取mockmvc对象实例
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
}

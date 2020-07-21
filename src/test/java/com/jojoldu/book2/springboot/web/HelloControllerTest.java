package com.jojoldu.book2.springboot.web;
import com.jojoldu.book2.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)        //JUnit과 스프링 부트 테스트의 연결자 역할
@WebMvcTest(controllers = HelloController.class,excludeFilters = {@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,
                        classes = SecurityConfig.class)})
public class HelloControllerTest {
    @Autowired              //스프링이 관리하는 bean을 주입 받음
    private MockMvc mvc;    //웹API를 테스트할 때 사용함, 스프링 MVC 테스트의 시작점

    @WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())             //mvc.perform의 결과 검증, 200 404 500등 상태 검증
                .andExpect(content().string(hello));      //응답 본문의 내용을 검증 "hello"가 맞는지 검증

    }

    @WithMockUser(roles="USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name",name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));

    }
}

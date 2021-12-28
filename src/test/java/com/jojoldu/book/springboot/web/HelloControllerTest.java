package com.jojoldu.book.springboot.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.is;
@SpringBootTest
@AutoConfigureMockMvc // MockMvc를 자동으로 만들기 위해서는 @AutoConfigureMockMvc 사용이 필요
class HelloControllerTest {

    /** MockMvc
     * 웹 API를 테스트할때 사용
     * 스프링 MVC테스트의 시작점
     * 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있다.
     */
    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser(roles = "USER")
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";


        /**
         * mvc.perform(get("/hello"))
         * MockMvc를 통해 /hello 주소로 HTTP GET 요청을 합니다.
         * 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있다.
         *
         * .andExpect(status().ikOK))
         * mvc.perform의 결과를 검증한다.
         * 우리가 흔히 알고 있는 200,404,500 등의 상태를 검증한다.
         * 여기선 OK 즉, 200인지 아닌지를 검증한다
         *
         * .andExcept(content().string(hello))
         * mvc.perform의 결과를 검증한다.
         * 응답 본문의 내용을 검증한다.
         * Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증한다.
         */
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }


     @Test
     @WithMockUser(roles = "USER")
     public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                                     .param("name", name)
                                     .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
     }


}
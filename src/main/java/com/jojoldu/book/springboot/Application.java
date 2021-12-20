package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 스프링 부트의 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정
 * 이 어노테이션이 있는 위치부터 설정을 읽어 가기때문에 이 클래스는 항상 프로젝트의 최상단에 위치 해야 한다.
 */
@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args); //내장 WAS 실행행
   }


}

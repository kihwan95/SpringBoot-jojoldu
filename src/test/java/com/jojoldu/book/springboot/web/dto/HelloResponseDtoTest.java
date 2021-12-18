package com.jojoldu.book.springboot.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class HelloResponseDtoTest {

    /**
     * 여기서 Junit의 기본 assertThat이 아닌 assertj의 assertThat을 사용한다.
     *                        그 이유는
     * 1. Junit의 assertThat을 쓰게되면 is()와 같이 CoreMatchers 라이브러리가 필요하다
     * 2. 자동완성이 좀 더 확실하게 지원된다.
     */
    @Test
    public void 롬복_기능_테스트(){
        String name = "test";
        int amount =1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
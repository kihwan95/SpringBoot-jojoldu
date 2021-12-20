package com.jojoldu.book.springboot.web.domain.posts;


import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;



@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){

        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";


        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("zpzp627@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();
        System.out.println("postsList:"  + postsList);

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

         @Test
         public void BaseTimeEntity_등록(){

             //given
             LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
             System.out.println("now:" + now);
             postsRepository.save(Posts.builder()
             .title("title")
             .content("content")
             .author("author")
             .build());

             //when
             List<Posts> postsList = postsRepository.findAll();

             //then
             Posts posts = postsList.get(0);

             System.out.println(">>>>>>>>>>>>> createDate =" + posts.getCreateDate()+", modifiedDate =" + posts.getModifiedDate());

             /**
              * isBefore() : 인자보다 과거일 때 true가 리턴
              * isAfter() : 인자보다 미래일 때 true가 리턴
              * isEqual() : 인자와 같은 시간일 때 true가 리턴
              */
             assertThat(posts.getCreateDate()).isAfter(now);
             assertThat(posts.getModifiedDate()).isAfter(now);



             //then


         }



}
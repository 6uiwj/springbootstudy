package org.choongang.jpaex;

import org.choongang.entities.BoardData;
import org.choongang.repositories.BoardDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex03Test {

    @Autowired
    private BoardDataRepository repository;

    @BeforeEach
    void init() {
        List<BoardData> items = new ArrayList<>();
        for (int i = 1; i<=10; i++) {
            BoardData item = new BoardData();
            item.setSubject("제목"+i);
            item.setContent("내용"+i);
            items.add(item);
        }

        repository.saveAllAndFlush(items);
    }

    @Test
    void test1 (){
        BoardData data = new BoardData();
        data.setSubject("제목");
        data.setContent("내용");

        //repository.save(data); //persistt(data)와 동일 - 영속성 안에 추가 (변화감지 O)
        //repository.flush(); // insert쿼리 수행
        data = repository.saveAndFlush(data); //영속상태 - 변화감지 가능
        //반환값을 받아야 반환값이 영속상태가 됨(-> data)
        data.setSubject("(수정)제목");
        //repository.flush(); //업데이트 (이렇게 flush만 하면 쿼리가 안먹히넹(버전차이인듯))
        //repository.saveAndFlush(data); //save해준 후  flush 하자

        //조회 실행 시 암묵적으로 flush()가 먼저 수행 -> 조회
        repository.save(data);
        //기본키를 가지고 조회
        //optional 형태이므로 data.getSeq()의 반환값이 없을 때 null 처리
        BoardData data2 = repository.findById(data.getSeq()).orElse(null);
        System.out.println(data2);
    }

    @Test
    void test2() {
        List<BoardData> items = repository.findAll();
        items.forEach(System.out::println);

    }

    @Test
    void test3() {

    }
}

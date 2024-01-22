package org.choongang.jpaex;

import org.choongang.entities.BoardData;
import org.choongang.repositories.BoardDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.Sort.Order.asc;
import static org.springframework.data.domain.Sort.Order.desc;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
//@Transactional //테스트할 때마다 DB에 같은 데이터가 쌓이므로 오류 발생
// 테스트 후 데이터를 rollback 해주기 위해 @Transactonal 사용
public class Ex04Test {
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
    void test1() {
        //List<BoardData> items = repository.findBySubjectContaining("1");
        //items.forEach(System.out::println);
        List<BoardData> items = repository.findBySubjectContainingOrderBySeqDesc("목");
        items.forEach(System.out::println); //item배열의 각 요소들을 출력
    }

        @Test
        void test2() {
        //정렬: 엔티티기준으로 입력
            Pageable pageable = PageRequest.of(0,3, Sort.by(desc("createdAt"),asc("seq")));
            Page<BoardData> data = repository.findBySubjectContaining("목",pageable);

            //Page의 .getContent(): 조회된 데이터를 리스트형태로 가져옴
            List<BoardData> items = data.getContent();
            items.forEach(System.out::println);
        }

}

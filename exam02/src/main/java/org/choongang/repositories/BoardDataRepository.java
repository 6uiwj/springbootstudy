package org.choongang.repositories;

import org.choongang.entities.BoardData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardDataRepository extends JpaRepository<BoardData, Long> {
    //BoardData엔티티에서 subject 필드를 가지고 검색을 할건데 'keyword'를 포함한 내용을 조회할 것임
    List<BoardData> findBySubjectContaining(String keyword);
}

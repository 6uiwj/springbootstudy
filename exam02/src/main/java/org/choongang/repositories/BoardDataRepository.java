package org.choongang.repositories;

import org.choongang.entities.BoardData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardDataRepository extends JpaRepository<BoardData, Long> {
    //BoardData엔티티에서 subject 필드를 가지고 검색을 할건데 'keyword'를 포함한 내용을 조회할 것임
    List<BoardData> findBySubjectContaining(String keyword);

    //반환값이 페이지 (페이징에 관련된 편의기능 추가)
    Page<BoardData> findBySubjectContaining(String keyword, Pageable pageable);
    List<BoardData> findBySubjectContainingOrderBySeqDesc(String keyword);

    //쿼리가 복잡할 때 @Query 어노테이션 이용(직접 JPA형태의 쿼리 입력)
    //엔티티명 기준이기 때문에 무조건 별칭을 써야 함
    @Query("SELECT b FROM BoardData b WHERE b.subject LIKE '%:key%' ORDER BY b.seq DESC")
    List<BoardData> getSubjects(@Param("key") String keyword);
}

package org.choongang.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Entity
@Data
@IdClass(BoardViewId.class)
public class BoardView {
    //seq, uid 두개를 조합해서 기본키로 만들자
    @Id
    private Long seq;
    @Id
    @Column(name="_uid") //uid는 오라클 내 예약어이므로 충돌을 막기 위해 이름 변경
    private int uid; //얘는 오라클 예약어이므로 오류가 뜰 수 있음, 설정을 따로해줘야 함
}


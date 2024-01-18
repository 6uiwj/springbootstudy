package org.choongang.entities;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//ID클래스
//두가지를 조합해서 유일해야 하므로 유일성 보장을 위해 EqualsAndHashCode 필요
//두값의 조합이 중복되면 안됨
//두 가지를 매개변수 형태로 추가할 수 있는 생성자 필요
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode //유일성 보장
public class BoardViewId {
    private Long seq;
    private int uid;
}


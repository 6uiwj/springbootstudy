package org.choongang.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

//공통으로 쓸 부분들 정의, 객체를 만들지 못하게 통제 (상속으로만 쓸 것이기 때문에 ) ->추상클래스로 만들자
//공통 속성으로 쓸 클래스라는 것을 알려주자. @MappedSuperclass
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) //이벤트리스너로 감지되도록 설정
public abstract class Base {
    @CreatedDate
    @Column(updatable = false) //수정이 불가능하도록 설정
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(insertable = false) //추가X, 수정O
    private LocalDateTime modifiedAt;

}

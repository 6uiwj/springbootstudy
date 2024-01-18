package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.choongang.commons.MemberType;

import java.util.Date;

@Data
@Entity //변화감지의 기준이 될 수 있는 데이터 하나를 의미, getter/setter가 필요
@Table(name="USERS", indexes = @Index(name="idx_member_createdAt", columnList="createdAt DESC"))
//기본테이블명은 클래스명과 같지만 이 어노테이션을 붙이면 users라는 테이블로 만들어짐?
//가입일자 순으로 내림차순 정렬
//entity 필드명 기준
//1. @EntityListeners(AuditingEntityListener.class) //엔터티 변화감지
//3.
public class Member extends Base {

    @Id //기본키(유일성)
    @GeneratedValue //알아서 시퀀스 객체가 만들어짐
    private Long seq;

    @Column(length=80, unique = true, nullable = false)
    private String email;

    @Column(length=40, nullable = false)
    private String name;

    @Column(length=65, name="userPw", nullable = false)
    private String password; //varchar2

    //@Lob //varchar2 > CLOB으로 변경
    @Transient //DB반영X,내부에만 반영
    private String introduction; //CLOB

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private MemberType type;
/* 2.
    //@CreationTimestamp //INSERT SQL 실행시
    @CreatedDate
    private LocalDateTime createdAt;

    //@UpdateTimestamp // UPDATE SQL 실행시
    @LastModifiedDate
    private LocalDateTime modifiedAt;


 */

    //@Temporal(TemporalType.DATE) //날짜
    //@Temporal(TemporalType.TIME) //시간
    @Temporal(TemporalType.DATE) //날짜+시간
    public Date dt; //날짜+시간

}
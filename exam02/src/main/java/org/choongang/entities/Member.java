package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.choongang.commons.MemberType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name="USERS", indexes = @Index(name="idx_member_createdAt", columnList="createdAt DESC"))
public class Member {
    @Id
    @GeneratedValue
    private Long seq;

    private String email;
    private String name;
    private String password;

    @Transient //DB반영X,내부에만 반영
    @Lob //varchar2 > CLOB으로 변경
    private String introduction; //CLOB

    @Enumerated(EnumType.STRING)
    private MemberType type;


    //@CreationTimestamp //INSERT SQL 실행시
    @CreatedDate
    private LocalDateTime createdAt;

    //@UpdateTimestamp // UPDATE SQL 실행시
    @LastModifiedDate
    private LocalDateTime modifiedAt;


    //@Temporal(TemporalType.DATE) //날짜
    //@Temporal(TemporalType.TIME) //시간
    @Temporal(TemporalType.DATE) //날짜+시간
    public Date dt; //날짜+시간

}
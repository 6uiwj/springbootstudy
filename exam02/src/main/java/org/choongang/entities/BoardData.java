package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class BoardData extends Base {
    @Id
    @GeneratedValue
    private Long seq;

    @Column(length=100, nullable = false)
    private String subject;

    @Lob
    @Column(nullable = false)
    private String content;
}

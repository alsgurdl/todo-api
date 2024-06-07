package com.jap;

import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_article")
public class Article {
    //기사코드
    @Id
    @Column(name = "article_code")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String articleCode;

    //제목
    @Column(length = 500)
    private String title;

    //본문
    @Column(length = 10000)
    private String text;

    //작성날짜
    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    //신문사
    @Column(name = "news_agency", length = 50)
    private String newsAgency;

    //작성자
    @Column(length = 50)
    private String writer;

    //사진
    @Column(length = 2500)
    private String img;

    //기사링크
    @Column(name = "article_rink",length = 2500)
    private String articleRink;
}

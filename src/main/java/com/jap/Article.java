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
    @Id
    @Column(name = "article_code")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String articleCode;

    @Column(length = 500)
    private String title;

    @Column(length = 10000)
    private String text;

    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "news_agency", length = 50)
    private String newsAgency;

    @Column(length = 50)
    private String writer;

    @Column(length = 2500)
    private String img;

    @Column(name = "article_rink",length = 2500)
    private String articleRink;
}

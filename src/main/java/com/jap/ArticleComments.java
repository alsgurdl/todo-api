package com.jap;
import jakarta.persistence.*;

import lombok.*;


@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_article_comments")
public class ArticleComments {
    @Id
    @Column(name = "comment_no")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String commentNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_code")
    private Article article;

    @Column(name = "text", length = 500)
    private String text;

}

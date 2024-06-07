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
@Table(name = "tbl_keywords")
public class KeyWords {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_code")
    private Article article;

    @Column(length = 50)
    private String keyword;

}

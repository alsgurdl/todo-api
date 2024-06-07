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
@Table(name = "tbl_board_post")
public class BoardPost {

    @Id
    @Column(name = "post_no")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String postNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User user;

    @Column(name = "region_name",length = 20)
    private String regionName;

    @Column(length = 10000)
    private String text;

    @CreationTimestamp
    @Column(name = "write_date")
    private LocalDateTime writeDate;

    @Column(length = 2500)
    private String img;
}

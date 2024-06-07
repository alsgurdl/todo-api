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
@Table(name = "tbl_local_chat")
public class LocalChat {
    @Id
    @Column(name = "area_code")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String areaCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User user;

    @Column(name = "region_name", length = 20)
    private String regionName;

    @Column(length = 300)
    private String text;

    @CreationTimestamp
    @Column(name = "write_date")
    private LocalDateTime writeDate;


}

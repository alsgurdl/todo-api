package com.jap;


import jakarta.persistence.*;

import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @Column(name = "user_no")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userNo;

    @Column(name = "profile_image", length = 1000)
    private String profileImage;


    @Size(max = 20)
    @Column(nullable = false, unique = true,  length = 100)
    private String email;

    @Size(max = 20)
    @Column(nullable = false, length = 50)
    private String password;

    @Size(max = 20)
    @Column(name = "phone_num", nullable = false)
    private String phoneNum;

    @Column(name = "region_name", length = 20,nullable = false)
    private String regionName;

    @Column(name = "favorite_keyword", length = 20)
    private String favoriteKeyword;

    @Column(name = "login_path", length = 20)
    private String loginPath = "COMMON";


}

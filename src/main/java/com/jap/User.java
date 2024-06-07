package com.jap;


import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
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
    //회원번호
    @Id
    @Column(name = "user_no")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userNo;

    //프로필 사진
    @Column(name = "profile_image", length = 1000)
    private String profileImage;

    //아이디(이메일)
    @Size(max = 20)
    @Email
    @Column(nullable = false, unique = true,  length = 100)
    private String email;

    //비밀번호
    @Size(max = 20)
    @Column(nullable = false, length = 50)
    private String password;

    //핸드폰 번호
    @Size(max = 20)
    @Column(name = "phone_num", nullable = false)
    private String phoneNum;

    //지역명
    @Column(name = "region_name", length = 20,nullable = false)
    private String regionName;

    //관심키워드
    @Column(name = "favorite_keyword", length = 20)
    private String favoriteKeyword;

    //로그인경로
    @Column(name = "login_path", length = 20)
    private String loginPath = "COMMON";


}

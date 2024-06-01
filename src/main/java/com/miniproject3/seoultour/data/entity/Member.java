package com.miniproject3.seoultour.data.entity;

import com.miniproject3.seoultour.data.AuthType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    private String userid;

    private String name;
    private String password;
    private String email;
    private AuthType authType;
//    private
}

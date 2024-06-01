package com.miniproject3.seoultour.data.dto;

import com.miniproject3.seoultour.data.AuthType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberRequestDto {
    private Long id;
    private String name;
    private String userid;
    private String password;
    private String email;
    private AuthType authType;
}

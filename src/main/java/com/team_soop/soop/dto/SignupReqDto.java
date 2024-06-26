package com.team_soop.soop.dto;

import com.team_soop.soop.entity.User;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class SignupReqDto {

    @Pattern(regexp = "^[A-Za-z0-9]{4,10}$", message = "영문자, 숫자 5 ~ 10자리 형식이어야 합니다")
    private String username;
    @Pattern(regexp = "^(?=.*[가-힣a-zA-Z])[가-힣a-zA-Z!@#$%^&*()?_0-9]{2,6}$", message = "최소한 한 글자 이상의 한글, 영문자가 반드시 포함되고 2에서 6자리 형식이어야 합니다")
    private String nickname;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{7,128}$", message = "하나의 영문자, 숫자, 특수문자를 포함한 5 ~ 128자리 형식이어야 합니다")
    private String password;    // 1q2w3e4r!
    @Pattern(regexp = "^[가-힇]{1,}$", message = "한글문자 형식이어야 합니다")
    private String name;
    @Email(regexp = "^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{1,3}$", message = "이메일 형식이어야 합니다")
    private String email;

    public User toEntity(BCryptPasswordEncoder passwordEncoder) {
        return User.builder()
                .username(username)
                .nickname(nickname)
                .password(passwordEncoder.encode(password))
                .name(name)
                .email(email)
                .build();
    }
}

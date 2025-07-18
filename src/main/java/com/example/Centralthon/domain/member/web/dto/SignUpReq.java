package com.example.Centralthon.domain.member.web.dto;

import jakarta.validation.constraints.AssertTrue;
import lombok.Data;
import lombok.Getter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Getter
public class SignUpReq {
    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "올바른 이메일 형식으로 작성해주세요.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d\\S]{8,20}$", message = "영문, 숫자를 포함한 8~20자리 이내로 입력해주세요.")
    private String password;

    @NotBlank(message = "비밀번호를 한 번 더 입력해주세요.")
    private String passwordCheck;

    @NotBlank(message = "이름을 입력해주세요.")
    private String nickName;

    @AssertTrue(message = "비밀번호가 일치하지 않습니다.")
    public boolean isPasswordMatching() {
        if (password == null || passwordCheck == null) return false;
        return password.equals(passwordCheck);
    }
}

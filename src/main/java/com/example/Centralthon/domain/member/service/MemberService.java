package com.example.Centralthon.domain.member.service;

import com.example.Centralthon.domain.member.web.dto.SignUpReq;
import com.example.Centralthon.global.response.SuccessResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface MemberService {

    void signUp( SignUpReq signupReq);
}

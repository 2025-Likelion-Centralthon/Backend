package com.example.Centralthon.domain.member.service;

import com.example.Centralthon.domain.member.entity.Member;
import com.example.Centralthon.domain.member.entity.enums.MemberRole;
import com.example.Centralthon.domain.member.exception.MemberAlreadyExistException;
import com.example.Centralthon.domain.member.exception.MemberErrorCode;
import com.example.Centralthon.domain.member.repository.MemberRepository;
import com.example.Centralthon.domain.member.web.dto.SignUpReq;
import com.example.Centralthon.global.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public void signUp(SignUpReq signUpReq) {
        if (memberRepository .findByEmailOrNickName(signUpReq.getEmail(), signUpReq.getNickName()) .isPresent()) {
            throw new MemberAlreadyExistException(); }

        String encoded = passwordEncoder.encode(signUpReq.getPassword());
        Member member = Member.toEntity(signUpReq.getEmail(),encoded,signUpReq.getNickName());

        memberRepository.save(member);
    }
}

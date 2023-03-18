package com.project.domain.entity;

import com.project.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Member {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long idxMem; //자동으로 늘어나는값
    
    @Email
    @Column(unique = true)
    private String memEmail; //이메일
    @NotEmpty 
    private String memPass; //비밀번호
    @NotEmpty 
    private String memName; //이름
    @NotEmpty 
    private String memPhone; //휴대폰
    @NotEmpty 
    private String memAddr; // 주소 
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    //주소
    @NotEmpty
    private String zipcode;
    @NotEmpty
    private String streetAdr;
    private String detailAdr;
}

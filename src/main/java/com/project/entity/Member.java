package com.project.entity;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.project.Role;
import com.project.dto.MemberFormDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter @Setter
public class Member {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idxMem")
    private Long idx; //자동으로 늘어나는값
    
    @Email
    @Column(name = "memEmail", unique = true)
    private String email; //이메일
    
    @NotEmpty 
    private String memPass; //비밀번호
    @NotEmpty 
    private String memName; //이름
    @NotEmpty 
    private String memPhone; //휴대폰
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    //주소
    @NotEmpty
    private String zipcode;
    @NotEmpty
    private String streetAdr;
    private String detailAdr;
    
    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder ) {
    	Member member = new Member();
    	member.setEmail(memberFormDto.getEmail());
    	String memPass = passwordEncoder.encode(memberFormDto.getMemPass());
    	member.setMemPass(memPass);
    	member.setMemName(memberFormDto.getMemName());
    	member.setMemPhone(memberFormDto.getMemPhone());
    	member.setZipcode(memberFormDto.getZipcode());
    	member.setStreetAdr(memberFormDto.getStreetAdr());
    	member.setDetailAdr(memberFormDto.getDetailAdr());
    	return member;
    }
}

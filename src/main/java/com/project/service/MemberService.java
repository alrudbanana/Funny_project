package com.project.service;

import org.springframework.stereotype.Service;

import com.project.entity.Member;
import com.project.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	public Member saveMember(Member member ) {
		validateDuplicateMember(member);
		return memberRepository.save(member);
	}
	
	private void validateDuplicateMember(Member member) {
	 Member findMember = memberRepository.findByEmail(member.getEmail());
		if(findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}
}
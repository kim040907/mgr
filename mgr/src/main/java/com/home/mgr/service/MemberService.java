package com.home.mgr.service;

import com.home.mgr.vo.MemberVO;

public interface MemberService {

	// 회원가입
	void insertMember(MemberVO memberVO);

	// 회원선택 아이디
	MemberVO selectMember(String memberEmail);
}

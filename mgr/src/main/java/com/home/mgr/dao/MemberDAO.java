package com.home.mgr.dao;

import com.home.mgr.vo.MemberVO;

public interface MemberDAO {
	// 회원가입
	void insertMember(MemberVO memberVO);

	// 회원선택 아이디
	MemberVO selectMember(String memberEmail);

	// 멤버 포인트 사용
	void memberFundPoint(MemberVO memberVO);
}

package com.home.mgr.dao;

import com.home.mgr.vo.MemberVO;

public interface MemberDAO {
	// ȸ������
	void insertMember(MemberVO memberVO);

	// ȸ������ ���̵�
	MemberVO selectMember(String memberEmail);
}

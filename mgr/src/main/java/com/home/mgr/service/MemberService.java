package com.home.mgr.service;

import com.home.mgr.vo.MemberVO;

public interface MemberService {

	// ȸ������
	void insertMember(MemberVO memberVO);

	// ȸ������ ���̵�
	MemberVO selectMember(String memberEmail);

	// ��� ����Ʈ ���
	void memberFundPoint(MemberVO memberVO);
}

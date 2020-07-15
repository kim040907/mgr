package com.home.mgr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.mgr.dao.MemberDAO;
import com.home.mgr.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDAO;

	@Override
	public void insertMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		memberDAO.insertMember(memberVO);
	}

	@Override
	public MemberVO selectMember(String memberEmail) {
		// TODO Auto-generated method stub
		return memberDAO.selectMember(memberEmail);
	}
}

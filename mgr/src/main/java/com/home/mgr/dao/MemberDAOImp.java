package com.home.mgr.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.home.mgr.vo.MemberVO;

@Repository
public class MemberDAOImp implements MemberDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public void insertMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		sqlSession.insert("insertMember", memberVO);
	}

	@Override
	public MemberVO selectMember(String memberEmail) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("selectMember", memberEmail);
	}
}

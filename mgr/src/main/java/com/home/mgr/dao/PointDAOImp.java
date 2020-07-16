package com.home.mgr.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.home.mgr.vo.PointVO;

@Repository
public class PointDAOImp implements PointDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public void insertPointHistory(PointVO pointVO) {
		// TODO Auto-generated method stub
		sqlSession.insert("insertPointHistory", pointVO);
	}
}

package com.home.mgr.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.home.mgr.vo.FundVO;

@Repository
public class FundDAOImp implements FundDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public void fundWrite(FundVO fundVO) {
		// TODO Auto-generated method stub
		sqlSession.insert("fundWrite", fundVO);
	}

	@Override
	public List<FundVO> selectFundList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("selectFundList");
	}

	@Override
	public FundVO selectFundDetail(String fundNum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("selectFundDetail", fundNum);
	}

	@Override
	public void fundFundPoint(FundVO fundVO) {
		// TODO Auto-generated method stub
		sqlSession.update("fundFundPoint", fundVO);
	}

}

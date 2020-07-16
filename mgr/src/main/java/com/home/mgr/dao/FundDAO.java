package com.home.mgr.dao;

import java.util.List;

import com.home.mgr.vo.FundVO;

public interface FundDAO {

	// 글쓰기
	void fundWrite(FundVO fundVO);

	// 펀드리스트 출력
	List<FundVO> selectFundList();

	// 펀드상세페이지
	FundVO selectFundDetail(int fundNum);

	// 펀드 포인트추가
	void fundFundPoint(FundVO fundVO);

}

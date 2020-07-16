package com.home.mgr.service;

import java.util.List;

import com.home.mgr.vo.FundVO;

public interface FundService {

	// 글쓰기
	void fundWrite(FundVO fundVO);

	// 펀드리스트 출력
	List<FundVO> selectFundList();

	// 펀드 상세페이지
	FundVO selectFundDetail(int fundNum);

	// 펀드포인트 추가
	void fundFundPoint(FundVO fundVO);
}

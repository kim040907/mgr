package com.home.mgr.service;

import java.util.List;

import com.home.mgr.vo.FundVO;

public interface FundService {

	// �۾���
	void fundWrite(FundVO fundVO);
	
	// �ݵ帮��Ʈ ���
	List<FundVO> selectFundList();

	// �ݵ� ��������
	FundVO selectFundDetail(String fundNum);

}

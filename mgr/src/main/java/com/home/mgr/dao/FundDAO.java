package com.home.mgr.dao;

import java.util.List;

import com.home.mgr.vo.FundVO;

public interface FundDAO {

	// �۾���
	void fundWrite(FundVO fundVO);

	// �ݵ帮��Ʈ ���
	List<FundVO> selectFundList();

	// �ݵ��������
	FundVO selectFundDetail(int fundNum);

	// �ݵ� ����Ʈ�߰�
	void fundFundPoint(FundVO fundVO);

}

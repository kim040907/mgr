package com.home.mgr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.mgr.dao.FundDAO;
import com.home.mgr.vo.FundVO;

@Service
public class FundServiceImp implements FundService {

	@Autowired
	FundDAO fundDAO;

	@Override
	public void fundWrite(FundVO fundVO) {
		// TODO Auto-generated method stub
		fundDAO.fundWrite(fundVO);
	}

	@Override
	public List<FundVO> selectFundList() {
		// TODO Auto-generated method stub
		return fundDAO.selectFundList();
	}

	@Override
	public FundVO selectFundDetail(String fundNum) {
		// TODO Auto-generated method stub
		return fundDAO.selectFundDetail(fundNum);
	}

}

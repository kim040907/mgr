package com.home.mgr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.mgr.dao.PointDAO;
import com.home.mgr.vo.PointVO;

@Service
public class PointServiceImp implements PointService {

	@Autowired
	PointDAO pointDAO;

	@Override
	public void insertPointHistory(PointVO pointVO) {
		// TODO Auto-generated method stub
		pointDAO.insertPointHistory(pointVO);
	}
}

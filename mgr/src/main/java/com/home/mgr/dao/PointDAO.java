package com.home.mgr.dao;

import com.home.mgr.vo.PointVO;

public interface PointDAO {

	// 포인트 내역 등록
	void insertPointHistory(PointVO pointVO);
}

package com.home.mgr.vo;

public class PointVO {

	private String pointNum;
	
	/*
	1 : 회원이 포인트 충전
	2 : 회원이 포인트 펀딩
	3 : 펀딩 미달 및 삭제시 포인트 환원
	*/
	
	private String pointType;
	// 포인트
	private int pointPoint;
	// 회원번호
	private int pointMembernum;
	// 펀드번호
	private int pointFundnum;
	
	public String getPointNum() {
		return pointNum;
	}
	public void setPointNum(String pointNum) {
		this.pointNum = pointNum;
	}
	public String getPointType() {
		return pointType;
	}
	public void setPointType(String pointType) {
		this.pointType = pointType;
	}
	public int getPointPoint() {
		return pointPoint;
	}
	public void setPointPoint(int pointPoint) {
		this.pointPoint = pointPoint;
	}
	public int getPointMembernum() {
		return pointMembernum;
	}
	public void setPointMembernum(int pointMembernum) {
		this.pointMembernum = pointMembernum;
	}
	public int getPointFundnum() {
		return pointFundnum;
	}
	public void setPointFundnum(int pointFundnum) {
		this.pointFundnum = pointFundnum;
	}
	@Override
	public String toString() {
		return "PointVO [pointNum=" + pointNum + ", pointType=" + pointType + ", pointPoint=" + pointPoint
				+ ", pointMembernum=" + pointMembernum + ", pointFundnum=" + pointFundnum + "]";
	}
}

package com.home.mgr.vo;

public class PointVO {

	private String pointNum;
	
	/*
	1 : ȸ���� ����Ʈ ����
	2 : ȸ���� ����Ʈ �ݵ�
	3 : �ݵ� �̴� �� ������ ����Ʈ ȯ��
	*/
	
	private String pointType;
	// ����Ʈ
	private int pointPoint;
	// ȸ����ȣ
	private int pointMembernum;
	// �ݵ��ȣ
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

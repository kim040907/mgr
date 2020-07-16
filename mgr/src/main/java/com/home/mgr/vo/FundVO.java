package com.home.mgr.vo;

public class FundVO {

	private int fundNum;
	private String fundCategory;
	private String fundTitle;
	private String fundContents;
	private String fundStartDate;
	private String fundEndDate;
	private int fundNeedpoint;
	private int fundCurrentpoint;

	public int getFundNum() {
		return fundNum;
	}

	public void setFundNum(int fundNum) {
		this.fundNum = fundNum;
	}

	public String getFundCategory() {
		return fundCategory;
	}

	public void setFundCategory(String fundCategory) {
		this.fundCategory = fundCategory;
	}

	public String getFundTitle() {
		return fundTitle;
	}

	public void setFundTitle(String fundTitle) {
		this.fundTitle = fundTitle;
	}

	public String getFundContents() {
		return fundContents;
	}

	public void setFundContents(String fundContents) {
		this.fundContents = fundContents;
	}

	public String getFundStartDate() {
		return fundStartDate;
	}

	public void setFundStartDate(String fundStartDate) {
		this.fundStartDate = fundStartDate;
	}

	public String getFundEndDate() {
		return fundEndDate;
	}

	public void setFundEndDate(String fundEndDate) {
		this.fundEndDate = fundEndDate;
	}

	public int getFundNeedpoint() {
		return fundNeedpoint;
	}

	public void setFundNeedpoint(int fundNeedpoint) {
		this.fundNeedpoint = fundNeedpoint;
	}

	public int getFundCurrentpoint() {
		return fundCurrentpoint;
	}

	public void setFundCurrentpoint(int fundCurrentpoint) {
		this.fundCurrentpoint = fundCurrentpoint;
	}

	@Override
	public String toString() {
		return "FundVO [fundNum=" + fundNum + ", fundCategory=" + fundCategory + ", fundTitle=" + fundTitle
				+ ", fundContents=" + fundContents + ", fundStartDate=" + fundStartDate + ", fundEndDate=" + fundEndDate
				+ ", fundNeedpoint=" + fundNeedpoint + ", fundCurrentpoint=" + fundCurrentpoint + "]";
	}

}

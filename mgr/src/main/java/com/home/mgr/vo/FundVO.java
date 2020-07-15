package com.home.mgr.vo;

public class FundVO {

	private String fundNum;
	private String fundCategory;
	private String fundTitle;
	private String fundContents;
	private String fundStartDate;
	private String fundEndDate;
	private String fundNeedMoney;

	public String getFundNum() {
		return fundNum;
	}

	public void setFundNum(String fundNum) {
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

	public String getFundNeedMoney() {
		return fundNeedMoney;
	}

	public void setFundNeedMoney(String fundNeedMoney) {
		this.fundNeedMoney = fundNeedMoney;
	}

	@Override
	public String toString() {
		return "FundVO [fundNum=" + fundNum + ", fundCategory=" + fundCategory + ", fundTitle=" + fundTitle
				+ ", fundContents=" + fundContents + ", fundStartDate=" + fundStartDate + ", fundEndDate=" + fundEndDate
				+ ", fundNeedMoney=" + fundNeedMoney + "]";
	}

}

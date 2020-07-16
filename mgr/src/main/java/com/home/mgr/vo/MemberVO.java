package com.home.mgr.vo;

public class MemberVO {

	private int memberNum;
	private String memberEmail;
	private String memberPassword;
	private String memberName;
	private int memberPoint;

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberPoint() {
		return memberPoint;
	}

	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}

	@Override
	public String toString() {
		return "MemberVO [memberNum=" + memberNum + ", memberEmail=" + memberEmail + ", memberPassword="
				+ memberPassword + ", memberName=" + memberName + ", memberPoint=" + memberPoint + "]";
	}
}

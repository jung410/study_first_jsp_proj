package com.min0s.member.vo;

public class Member {
	private String name;
	private String userid;
	private String password;
	private String postcode;
	private String roadAddr;
	private String detailAddr;
	private String email;
	private boolean refundType;
	private boolean reciveEmail;
	
	// 생성자
	public Member() {}
	public Member(String name, String userid, String password, String postcode, String roadAddr, String detailAddr,
			String email, boolean refundType, boolean reciveEmail) {
		this.name = name;
		this.userid = userid;
		this.password = password;
		this.postcode = postcode;
		this.roadAddr = roadAddr;
		this.detailAddr = detailAddr;
		this.email = email;
		this.refundType = refundType;
		this.reciveEmail = reciveEmail;
	}
	
	// getter/setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getRoadAddr() {
		return roadAddr;
	}
	public void setRoadAddr(String roadAddr) {
		this.roadAddr = roadAddr;
	}
	public String getDetailAddr() {
		return detailAddr;
	}
	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isRefundType() {
		return refundType;
	}
	public void setRefundType(boolean refundType) {
		this.refundType = refundType;
	}
	public boolean isReciveEmail() {
		return reciveEmail;
	}
	public void setReciveEmail(boolean reciveEmail) {
		this.reciveEmail = reciveEmail;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", userid=" + userid + ", password=" + password + ", postcode=" + postcode
				+ ", roadAddr=" + roadAddr + ", detailAddr=" + detailAddr + ", email=" + email + ", refundType="
				+ refundType + ", reciveEmail=" + reciveEmail + "]";
	}
}

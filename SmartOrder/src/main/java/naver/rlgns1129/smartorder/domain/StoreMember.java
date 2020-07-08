package naver.rlgns1129.smartorder.domain;

import java.util.Date;

public class StoreMember {
	private String memberNickname;
	private String memberEmail;
	private String memberPassword;
	private String memberPhoneNumber;
	private String memberIsLogin;
	private Date memberLastLoginDate;
	private String memberIsRemove;

	public StoreMember() {
		super();
	}

	public StoreMember(String memberNickname, String memberEmail, String memberPassword, String memberPhoneNumber,
			String memberIsLogin, Date memberLastLoginDate, String memberIsRemove) {
		super();
		this.memberNickname = memberNickname;
		this.memberEmail = memberEmail;
		this.memberPassword = memberPassword;
		this.memberPhoneNumber = memberPhoneNumber;
		this.memberIsLogin = memberIsLogin;
		this.memberLastLoginDate = memberLastLoginDate;
		this.memberIsRemove = memberIsRemove;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
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

	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}

	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}

	public String getMemberIsLogin() {
		return memberIsLogin;
	}

	public void setMemberIsLogin(String memberIsLogin) {
		this.memberIsLogin = memberIsLogin;
	}

	public Date getMemberLastLoginDate() {
		return memberLastLoginDate;
	}

	public void setMemberLastLoginDate(Date memberLastLoginDate) {
		this.memberLastLoginDate = memberLastLoginDate;
	}

	public String getMemberIsRemove() {
		return memberIsRemove;
	}

	public void setMemberIsRemove(String memberIsRemove) {
		this.memberIsRemove = memberIsRemove;
	}

	@Override
	public String toString() {
		return "StoreMember [memberNickname=" + memberNickname + ", memberEmail=" + memberEmail + ", memberPassword="
				+ memberPassword + ", memberPhoneNumber=" + memberPhoneNumber + ", memberIsLogin=" + memberIsLogin
				+ ", memberLastLoginDate=" + memberLastLoginDate + ", memberIsRemove=" + memberIsRemove + "]";
	}
}
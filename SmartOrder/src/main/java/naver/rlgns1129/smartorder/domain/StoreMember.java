package naver.rlgns1129.smartorder.domain;

import java.util.Date;

import lombok.Data;
@Data
public class StoreMember {
	private String memberNickname;
	private String memberEmail;
	private String memberPassword;
	private String memberPhoneNumber;
	private String memberIsLogin;
	private Date memberLastLoginDate;
	private String memberIsRemove;

	
}
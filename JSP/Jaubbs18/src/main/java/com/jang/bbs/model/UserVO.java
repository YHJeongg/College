package com.jang.bbs.model;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserVO {
	
	
	private int mno;
	
	@NotEmpty(message="id�� �Է��ϼ���!")
	private String userId;
	@NotEmpty(message="�н����带 �Է��ϼ���!")
	private String passwd;
	private String name;
	private String jumin;
	private String regDate;
	private String email;
	private char del_yn='n';
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}

	
}

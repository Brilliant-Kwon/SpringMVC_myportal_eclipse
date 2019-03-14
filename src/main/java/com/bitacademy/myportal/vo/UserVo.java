package com.bitacademy.myportal.vo;

import java.sql.Date;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserVo {
	private Long no;
	@NotEmpty
	@Length(min=2, max=8)
	private String name;
	private String password;
	@NotEmpty
	@Email
	private String email;
	private String gender;
	private Date createdAt;

	//생성자


	public UserVo() {
		super();
	}

	@Override
	public String toString() {
		return "UserVo{" +
				"no=" + no +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", gender='" + gender + '\'' +
				", createdAt=" + createdAt +
				'}';
	}

	public UserVo(String name, String email, String gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	public UserVo(Long no, String name, String email, String gender, Date createdAt) {
		this.no = no;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.createdAt = createdAt;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

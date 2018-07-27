package com.fishing.dto;

public class MemberVO {
    private String id;
    private String pw;
    private String name;
    private String email;
    private String nickName;
    private String birthday;
    private String phone;
    private String addr;
    
   
    public MemberVO() {
		
	}


	public MemberVO(String id, String pw, String name, String email, String nickName, String birthday, String phone,
			String addr) {
		
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.nickName = nickName;
		this.birthday = birthday;
		this.phone = phone;
		this.addr = addr;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
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


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", nickName=" + nickName
				+ ", birthday=" + birthday + ", phone=" + phone + ", addr=" + addr + "]";
	}


	
    
    
  
}
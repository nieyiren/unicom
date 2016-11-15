package com.transwarp.unicom.vo;

public class D_ST_SMS_VO {

	// 用户ID
	private String str_id_user;
	// 发送短信总数
	private int int_sms_send;
	//收到短信总数
	private int int_sms_receive;
	
	public String getStr_id_user() {
		return str_id_user;
	}
	public void setStr_id_user(String str_id_user) {
		this.str_id_user = str_id_user;
	}
	public int getInt_sms_send() {
		return int_sms_send;
	}
	public void setInt_sms_send(int int_sms_send) {
		this.int_sms_send = int_sms_send;
	}
	public int getInt_sms_receive() {
		return int_sms_receive;
	}
	public void setInt_sms_receive(int int_sms_receive) {
		this.int_sms_receive = int_sms_receive;
	}
	
	
	
}

package com.transwarp.unicom.bean;

//短信统计
public class D_ST_SMS {
	
	//日期
	private String dt_recode;
	//用户ID
	private String str_id_user;
	//发送短信总数
	private int int_sms_send;
	//收发总次数
	private int int_sms;
	public String getDt_recode() {
		return dt_recode;
	}
	public void setDt_recode(String dt_recode) {
		this.dt_recode = dt_recode;
	}
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
	public int getInt_sms() {
		return int_sms;
	}
	public void setInt_sms(int int_sms) {
		this.int_sms = int_sms;
	}
	
	

}

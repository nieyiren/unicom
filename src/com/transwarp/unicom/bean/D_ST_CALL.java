package com.transwarp.unicom.bean;

//通话统计
public class D_ST_CALL {

	//日期
	private String dt_recode;
	//用户
	private String st_id_user;
	//主叫通话频次
	private int int_ct_caller;
	//主叫通话总时长
	private int int_pd_caller;
	//总通话次数
	private int int_ct_call;
	//总通话时长
	private int int_pd_call;
	//最大通话时长
	private int int_pd_max_call;
	
	public String getDt_recode() {
		return dt_recode;
	}
	public void setDt_recode(String dt_recode) {
		this.dt_recode = dt_recode;
	}
	public String getSt_id_user() {
		return st_id_user;
	}
	public void setSt_id_user(String st_id_user) {
		this.st_id_user = st_id_user;
	}
	public int getInt_ct_caller() {
		return int_ct_caller;
	}
	public void setInt_ct_caller(int int_ct_caller) {
		this.int_ct_caller = int_ct_caller;
	}
	public int getInt_pd_caller() {
		return int_pd_caller;
	}
	public void setInt_pd_caller(int int_pd_caller) {
		this.int_pd_caller = int_pd_caller;
	}
	public int getInt_ct_call() {
		return int_ct_call;
	}
	public void setInt_ct_call(int int_ct_call) {
		this.int_ct_call = int_ct_call;
	}
	public int getInt_pd_call() {
		return int_pd_call;
	}
	public void setInt_pd_call(int int_pd_call) {
		this.int_pd_call = int_pd_call;
	}
	public int getInt_pd_max_call() {
		return int_pd_max_call;
	}
	public void setInt_pd_max_call(int int_pd_max_call) {
		this.int_pd_max_call = int_pd_max_call;
	}
	
	
	

}

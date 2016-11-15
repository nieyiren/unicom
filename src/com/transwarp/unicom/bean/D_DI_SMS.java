package com.transwarp.unicom.bean;

//短信频次分布
public class D_DI_SMS {

	//日期
	private String dt_recode;
	//分布区间项
	private int int_di_type;
	//分布区间值
	private int int_value;
	public String getDt_recode() {
		return dt_recode;
	}
	public void setDt_recode(String dt_recode) {
		this.dt_recode = dt_recode;
	}
	public int getInt_di_type() {
		return int_di_type;
	}
	public void setInt_di_type(int int_di_type) {
		this.int_di_type = int_di_type;
	}
	public int getInt_value() {
		return int_value;
	}
	public void setInt_value(int int_value) {
		this.int_value = int_value;
	}
	
	
}

package com.transwarp.unicom.task;

import java.util.List;

import com.transwarp.unicom.bean.D_DI_SMS;
import com.transwarp.unicom.bean.D_ST_SMS;
import com.transwarp.unicom.service.SmsService;
import com.transwarp.unicom.vo.D_ST_SMS_VO;

public class T_DailyStatOfSMS implements Runnable{

	private SmsService smsService = new SmsService();
	private String today = null;
	private List<D_ST_SMS_VO> vo_list = null;
	private List<D_ST_SMS> sms_list = null;
	private List<D_DI_SMS> di_list = null;
	private String taskName = null;
	
	public T_DailyStatOfSMS(String taskName){
		this.taskName = taskName;
	}
	
	@Override
	public void run() {
		today = "2016-09-11";
		vo_list = smsService.queryByDate(today);
		sms_list = smsService.st_sms_statistic(vo_list, today);
		smsService.save_st_sms(sms_list);
		di_list = smsService.di_sms_statistic(sms_list);
		System.out.println("di_list:"+di_list.size());
		smsService.save_di_sms(di_list);
		System.out.println(taskName+":任务执行完毕");
	}

}

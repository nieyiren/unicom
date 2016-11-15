package com.transwarp.unicom.service;

import java.util.ArrayList;
import java.util.List;

import com.transwarp.unicom.bean.B_DI_DICT;
import com.transwarp.unicom.bean.D_DI_SMS;
import com.transwarp.unicom.bean.D_ST_SMS;
import com.transwarp.unicom.dao.B_Di_DictDao;
import com.transwarp.unicom.dao.SmsDao;
import com.transwarp.unicom.vo.D_ST_SMS_VO;

public class SmsService {

	private SmsDao smsDao = new SmsDao();
	private B_Di_DictDao dictDao = new B_Di_DictDao();

	// 获取每日短信信息统计
	public List<D_ST_SMS_VO> queryByDate(String date) {
		return smsDao.queryByDate(date);
	}

	// 进行短信频次统计
	public List<D_ST_SMS> st_sms_statistic(List<D_ST_SMS_VO> vo_list, String date) {
		List<D_ST_SMS> sms_list = new ArrayList<D_ST_SMS>();
		for (D_ST_SMS_VO vo : vo_list) {
			D_ST_SMS sms = new D_ST_SMS();
			sms.setDt_recode(date);
			sms.setStr_id_user(vo.getStr_id_user());
			sms.setInt_sms_send(vo.getInt_sms_send());
			sms.setInt_sms(vo.getInt_sms_receive() + sms.getInt_sms_send());
			sms_list.add(sms);
		}
		return sms_list;
	}

	// 短信频次分布统计
	public List<D_DI_SMS> di_sms_statistic(List<D_ST_SMS> sms_list) {
		// 获取分布区间
		List<B_DI_DICT> dict_list = dictDao.getInterval(1);
		// 各分布区间分布值集合
		List<Integer> dis_list = new ArrayList<Integer>();
		int count = 0;
		// 计算各区间分布值
		for (int i = 0; i < dict_list.size(); i++) {
			count = 0;
			for (D_ST_SMS sms : sms_list) {
				if (sms.getInt_sms() >= dict_list.get(i).getDbl_min()
						&& sms.getInt_sms() < dict_list.get(i).getDbl_max()) {
					count++;
				}
			}
			// 将各区间分布值放进列表
			dis_list.add(count);
		}
		
		// 区间分布数据对象集合
		List<D_DI_SMS> di_list = new ArrayList<D_DI_SMS>();
		//将区间分布对象赋值
		for(int i = 0;i < dis_list.size();i++){
			D_DI_SMS di_sms = new D_DI_SMS();
			di_sms.setDt_recode(sms_list.get(1).getDt_recode());
			di_sms.setInt_di_type(dict_list.get(i).getInt_id());
			di_sms.setInt_value(dis_list.get(i));
			di_list.add(di_sms);
		}
		return di_list;
	}

	public boolean save_st_sms(List<D_ST_SMS> sms_list) {
		boolean b = false;
		smsDao.save_st_sms(sms_list);
		return b;
	}

	public boolean save_di_sms(List<D_DI_SMS> di_list) {
		boolean b = false;
		smsDao.save_di_sms(di_list);
		return b;
	}
}

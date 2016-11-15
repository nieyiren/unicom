package com.transwarp.unicom.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.transwarp.unicom.bean.D_DI_SMS;
import com.transwarp.unicom.bean.D_ST_SMS;
import com.transwarp.unicom.vo.D_ST_SMS_VO;

public class SmsDao extends DataBaseDao {

	// 获取日期为date的
	public List<D_ST_SMS_VO> queryByDate(String date) {
		String sql = "select a.s1,b.s2,a.m1,b.m2 from (select sender_num s1,COUNT(sender_num) m1 from duanxin where to_date(starttime) = '"
				+ date
				+ "' group by s1) a full outer join (select receiver_num s2,COUNT(receiver_num) m2 from duanxin where to_date(starttime) = '"
				+ date + "' group by s2) b on (a.s1 = b.s2)";
		ResultSet rs = query(sql);
		List<D_ST_SMS_VO> vo_list = RSToList(rs);
		close();
		return vo_list;
	}

	// 保存统计数据
	public boolean save_st_sms(List<D_ST_SMS> sms_list) {
		boolean b = false;
		String sql = "insert into d_st_sms(id,dt_recode,str_id_user,int_sms_send,int_sms) values(?,?,?,?,?)";
		try {
			con = connection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			int i = 0;
			for (D_ST_SMS sms : sms_list) {
				ps.setString(1, sms.getDt_recode() + sms.getStr_id_user());
				ps.setString(2, sms.getDt_recode());
				ps.setString(3, sms.getStr_id_user());
				ps.setInt(4, sms.getInt_sms_send());
				ps.setInt(5, sms.getInt_sms());
				ps.addBatch();
				i++;
				if (i % 10000 == 0) {
					ps.executeBatch();
					con.commit();
				}
			}
			ps.executeBatch();
			con.commit();
			con.setAutoCommit(true);
			close();
			b = true;
		} catch (Exception e) {
			System.out.println("SmsDao save_st_sms():" + e);
			e.printStackTrace();
			b = false;
		}
		return b;
	}

	// 保存短信频次分布数据
	public boolean save_di_sms(List<D_DI_SMS> di_list) {
		boolean b = false;
		if (null == di_list || di_list.size() == 0) {
			return b;
		}
		// 批量写入数据库
		try {
			String sql = "insert into d_di_sms(id,dt_recode,int_di_type,int_value) values(?,?,?,?)";
			con = connection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			int i = 0;
			for (D_DI_SMS sms : di_list) {
				ps.setString(1, sms.getDt_recode() + sms.getInt_di_type());
				ps.setString(2, sms.getDt_recode());
				ps.setInt(3, sms.getInt_di_type());
				ps.setInt(4, sms.getInt_value());
				ps.addBatch();
				i++;
				if (i % 10000 == 0) {
					ps.executeBatch();
					con.commit();
				}
			}
			ps.executeBatch();
			con.commit();
			con.setAutoCommit(true);
			close();
			b = true;
		} catch (Exception e) {
			b = false;
			System.out.println("SmsDao-->save_d_di_sms():" + e.getMessage());
		}
		return b;
	}

	// 将ResultSet转换为List
	public List<D_ST_SMS_VO> RSToList(ResultSet rs) {
		List<D_ST_SMS_VO> vo_list = new ArrayList<D_ST_SMS_VO>();
		try {
			while (rs.next()) {
				D_ST_SMS_VO vo = new D_ST_SMS_VO();
				if (null == rs.getString(1)) {
					vo.setStr_id_user(rs.getString(2));
					vo.setInt_sms_receive(rs.getInt(4));
					vo.setInt_sms_send(0);
				} else if (null == rs.getString(2)) {
					vo.setStr_id_user(rs.getString(1));
					vo.setInt_sms_send(Integer.parseInt(rs.getString(3)));
					vo.setInt_sms_receive(0);
				} else {
					vo.setStr_id_user(rs.getString(1));
					vo.setInt_sms_send(Integer.parseInt(rs.getString(3)));
					vo.setInt_sms_receive(rs.getInt(4));
				}
				vo_list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SMSDAO-->RStoList():" + e.getMessage());
		}
		return vo_list;
	}

}

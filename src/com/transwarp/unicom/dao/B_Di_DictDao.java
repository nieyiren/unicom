package com.transwarp.unicom.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.transwarp.unicom.bean.B_DI_DICT;

public class B_Di_DictDao extends DataBaseDao{
	
	//根据类别字典标志获取区间
	public List<B_DI_DICT> getInterval(int int_type_id){
		String sql = "select int_id,dbl_min,dbl_max from b_di_dict where int_type_id = "+int_type_id;
		return rsToList(query(sql));
	}
	
	public List<B_DI_DICT> rsToList(ResultSet rs){
		List<B_DI_DICT> dict_list = new ArrayList<B_DI_DICT>();
		try {
			while(rs.next()){
				B_DI_DICT dict = new B_DI_DICT();
				dict.setInt_id(rs.getInt(1));
				dict.setDbl_min(rs.getDouble(2));
				dict.setDbl_max(rs.getDouble(3));
				dict_list.add(dict);
			}
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("B_Di_DictDao-->rsToList():"+e.getMessage());
		}
		
		return dict_list;
	}

}

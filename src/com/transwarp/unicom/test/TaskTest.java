package com.transwarp.unicom.test;

import java.util.concurrent.TimeUnit;

import com.transwarp.unicom.task.T_DailyStatOfSMS;
import com.transwarp.unicom.task.TaskManager;

public class TaskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T_DailyStatOfSMS task1 = new T_DailyStatOfSMS("����ͳ������");
		System.out.println("����ʼִ�С�");
		TaskManager manager = new TaskManager(task1, 0, 3600, TimeUnit.SECONDS);
		manager.executeTask();

	}

}

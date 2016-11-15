package com.transwarp.unicom.test;

import java.util.concurrent.TimeUnit;

import com.transwarp.unicom.task.T_DailyStatOfSMS;
import com.transwarp.unicom.task.TaskManager;

public class TaskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T_DailyStatOfSMS task1 = new T_DailyStatOfSMS("短信统计任务");
		System.out.println("任务开始执行。");
		TaskManager manager = new TaskManager(task1, 0, 3600, TimeUnit.SECONDS);
		manager.executeTask();

	}

}

package com.transwarp.unicom.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskManager {
	
	private long initialDelay = 0;
    private long period = 0;
    private TimeUnit unit = TimeUnit.SECONDS;
	private static ScheduledExecutorService service = null;
	private Runnable task = null;
	
	static{
		service =  Executors.newScheduledThreadPool(10);
	}
	
	public TaskManager(){
		
	}
	
	
	public TaskManager(Runnable task,long initialDelay,long period,TimeUnit unit){
		this.task = task;
		this.initialDelay = initialDelay;
		this.period = period;
		this.unit  = unit;
	}
	
	public void executeTask(){
		TaskManager.service.scheduleAtFixedRate(task, initialDelay, period, unit);
	}
	
	public void executeTask(Runnable task,long initialDelay,long period,TimeUnit unit){
		TaskManager.service.scheduleAtFixedRate(task, initialDelay, period, unit);
	}

}

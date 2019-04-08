package com.learning.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

public class SimplePerformanceMonitor {
	
	public Object monitoring(ProceedingJoinPoint joinPoint) throws Throwable{
		StopWatch stopWatch = new StopWatch("Simple Monitoring");
		stopWatch.start(joinPoint.toShortString()); // Timer 시작

		try {
			return joinPoint.proceed(); // Target Object 메소드 실행 
		} catch (RuntimeException e) {
			endStopWatch(stopWatch, e);
			throw e;
		} finally {
			endStopWatch(stopWatch, null);
		}
	}
	
	// Timer 종료 메소드
	private void endStopWatch(StopWatch stopWatch, Throwable throwable){
		stopWatch.stop(); // Timer 종료
		
		TaskInfo taskInfo = stopWatch.getLastTaskInfo(); // 작업정보
		String taskName = taskInfo.getTaskName(); // 작업 명
		long time = taskInfo.getTimeMillis(); // 작업 시간
		
		String errorMessage = (throwable == null ? "" : ", ERROR > " + throwable.getMessage());
		
		System.out.format("%s : %d ms %s \n", taskName, time, errorMessage);
	}
}


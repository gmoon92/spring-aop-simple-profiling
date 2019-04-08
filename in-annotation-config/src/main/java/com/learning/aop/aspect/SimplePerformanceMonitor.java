package com.learning.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

@Aspect
@Component
public class SimplePerformanceMonitor {
	
	// 포인트 컷
	@Pointcut ("execution(* com.learning.aop.business.*.*(..))")
	private void businessService () {}
	
	@Around(value="businessService()")
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


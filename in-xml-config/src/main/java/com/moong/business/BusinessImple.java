package com.moong.business;

import org.springframework.stereotype.Component;

@Component
public class BusinessImple implements Business{
	@Override
	public void doAction() throws Exception {
		Thread.sleep(500); // 실행 0.5초 지연
	}

	@Override
	public void doRuntimeException() {
		throw new RuntimeException("에러가 발생하였습니다.");
	}
}
package sample.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import sample.module.autoconfig.SomeService;

@Component
public class SimpleRunner implements ApplicationRunner {

	@Autowired
	private SomeService someService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//
		// autoconfig 모듈 정상여부 확인
		//
		someService.action();

	}

}

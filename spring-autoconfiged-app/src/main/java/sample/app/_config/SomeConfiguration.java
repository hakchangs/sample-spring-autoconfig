package sample.app._config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample.module.autoconfig.SomeService;

@Configuration
public class SomeConfiguration {

	//
	//Bean 로딩 우선순위
	//1. Overide 된 빈: 여기서 정의된 빈
	//2. Autoconfig 로 설정된 빈
	//
	@Bean
	public SomeService someService() {
		return new SomeService("overiding-bean", true);
	}
	
}

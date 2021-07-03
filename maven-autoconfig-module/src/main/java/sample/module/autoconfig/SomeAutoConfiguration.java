package sample.module.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SomeProperties.class)
public class SomeAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean	//재정의한 bean 이 없으면, 현재 bean 사용 (autoconfig 사용시점)
	public SomeService someService(SomeProperties props) {
		
		//
		// 속성값 설정 (없으면, default 값 설정)
		//
		SomeService service = new SomeService(
				props.getServiceName() != null ? props.getServiceName() : "something",
				props.isActive() != null ? props.isActive() : false);
		
		return service;
		
	}
	
}

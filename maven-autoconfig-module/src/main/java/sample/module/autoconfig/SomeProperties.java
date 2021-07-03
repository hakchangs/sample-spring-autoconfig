package sample.module.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sample.some")
public class SomeProperties {

	/**
	 * 서비스 이름. default="something"
	 */
	private String serviceName;
	
	/**
	 * 서비스 활성여부. default=false
	 */
	private Boolean active;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
}

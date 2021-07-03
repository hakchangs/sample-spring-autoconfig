package sample.module.autoconfig;

public class SomeService {

	private String serviceName;
	private boolean active;
	
	public SomeService(String serviceName, boolean active) {
		this.serviceName = serviceName;
		this.active = active;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void action() {
		System.out.println("SomeService Informations={");
		System.out.println("serviceName=" + serviceName);
		System.out.println("active=" + active);
		System.out.println("}");
	}
	
}

package Parameters;

import java.util.Map;

public class GroupParameter {
	
	private ParameterSpec spec;
	
	public GroupParameter(ParameterSpec spec) {
		this.spec = spec;
	}
	
	public void setSpec(ParameterSpec spec) {
		this.spec = spec;
	}
	
	public ParameterSpec getSpec() {
		return spec;
	}
	
	public void addParameter(String propertyName, String property) {
		spec.getProperties().put(propertyName, property);
	}
	
	public Object removeParameter(String propertyName) {
		return spec.getProperties().remove(propertyName);
	}

}

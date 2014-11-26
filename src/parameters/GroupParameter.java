package parameters;

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
	
	public void addParameter(Param propertyName, String property) {
		spec.getProperties().put(propertyName, property);
	}
	
	public String removeParameter(Param propertyName) {
		return spec.getProperties().remove(propertyName);
	}
}

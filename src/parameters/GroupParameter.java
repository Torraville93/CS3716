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
	
	public String toString(){
		return spec.toString();
	}
}

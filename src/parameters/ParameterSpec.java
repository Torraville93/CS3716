package parameters;
import java.util.EnumMap;

public class ParameterSpec {
	
	private EnumMap<Param,String> properties = null;
	
	public ParameterSpec() { properties = new EnumMap<Param, String>(Param.class); }
	public ParameterSpec(EnumMap<Param,String> properties) {
		if (properties == null) {
			this.properties = new EnumMap<Param, String>(Param.class);;
		} else {
			this.properties = new EnumMap<Param,String>(properties);
		}
	}

	public void addProperty(Param propertyName, String property) {
		properties.put(propertyName, property);
	}

	public void setProperties(EnumMap<Param,String> properties) {
		this.properties = properties;
	}
  
	public String getProperty(Param propertyName) {
		return properties.get(propertyName);
	}

	public EnumMap<Param,String> getProperties() {
		return properties;
	}
	
	
	
	/*private EnumMap<Param,String> properties = null;
	
	public ParameterSpec() { properties = new EnumMap<Param, String>(Param.class); }
	public ParameterSpec(EnumMap properties) {
		if (properties == null) {
			this.properties = new EnumMap<Param, String>(Param.class);;
		} else {
			this.properties = new EnumMap(properties);
		}
	}

	public void addProperty(String propertyName, String property) {
		properties.put(propertyName, property);
	}

	public void setProperties(Map properties) {
		this.properties = properties;
	}
  
	public Object getProperty(String propertyName) {
		return properties.get(propertyName);
	}

	public Map getProperties() {
		return properties;
	}*/

}

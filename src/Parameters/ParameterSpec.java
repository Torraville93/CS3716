package Parameters;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class ParameterSpec {
	
	private EnumMap<Param,String> properties = null;
	
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
	}
}

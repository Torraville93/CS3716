package parameters;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton collection of Parameter objects
 * @param <GroupParameter>
 */
public class ParameterCollection<GroupParameter> {

	private static List singleton = new ArrayList();
	   
	   /** A private Constructor prevents any other 
	    *  class from instantiating.
	    */
	   private ParameterCollection() { }
	   
	   /**
	    * Static 'instance' method
	    * @return singleton collection
	    */
	   public static List getInstance() {
		   return singleton;
	   }
}

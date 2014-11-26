package parameters;

import java.util.ArrayList;

/**
 * Singleton collection of Parameter objects
 * @param <GroupParameter>
 */
public class ParameterCollection<GroupParameter> {

	private static ArrayList singleton = new ArrayList();
	   
	   /** A private Constructor prevents any other 
	    *  class from instantiating.
	    */
	   private ParameterCollection() { }
	   
	   /**
	    * Static 'instance' method
	    * @return singleton collection
	    */
	   public static ArrayList getInstance() {
		   return singleton;
	   }
}

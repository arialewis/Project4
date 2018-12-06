/**
 * @author Aria Lewis
 * @version 2018-10-18
 * 
 * Holds a single observation from Mesonet file and flags it if it is incorrect
 */
public class Observation {
	
	/** Value of the observation*/
	double value;
	
	/** Test for if the observation is valid*/
	boolean valid;
	
	/** Station location of the observation*/
	String stid;
	
	/**
	 * Constructor for the Observation object
	 * 
	 * @param value Value of the observation
	 * @param stid Station name of the observation
	 * @return
	 */
	public Observation(double value, String stid) {
		this.value = value;
		this.stid = stid;
	}
	
	/**
	 * Gets the value of an observation
	 * @return value of the observation, in double data type
	 */
	public double getValue() {
		return this.value;
	}
	
	/**
	 * Tests if an observation is valid, values at -999 are not valid
	 * 
	 * @return True or false if observation is valid
	 */
	public boolean isValid() {
		
		if (this.value < -900) {
			this.valid =  false;
		}
		else this.valid = true;
		
		return this.valid;
	}
	
	/**
	 * Gets the station name of an observation
	 * 
	 * @return Station name of the observation location, in String object
	 */
	public String getStid() {
		return this.stid;
	}
	
	/**
	 * Gives the toString for the Observation object
	 * 
	 * @return toString for the Observation 
	 */
	public String toString() {
		
		// Create a return String
		String ret = "";
		
		// Get values from Observation
		ret = this.value + " at " + this.stid;
		
		return ret;
	}

}

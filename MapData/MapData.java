package MapData;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.IOException;
import java.text.ParseException;

/**
 * MapData class, creates a set of statistics based on a given data set.
 * 
 * @author Aria Lewis, Billy Lo
 * @version 
 *
 */
public class MapData {

	/*
	 *  ArrayLists of certain data parameters
	 */
	
	/* */
	HashMap<String, ArrayList<Observation>> dataCatalog = new HashMap<String, ArrayList<Observation>>();
	
	/* */
	EnumMap<StatsType, TreeMap<String, Statistics>> statistics = new EnumMap<>(StatsType.class);
	/* */
	TreeMap<String, Integer> paramPositions = new TreeMap<String, Integer>();
	
	// ArrayList<Observation> sradData = new ArrayList<Observation>();
	///ArrayList<Observation> tairData = new ArrayList<Observation>();
	//ArrayList<Observation> ta9mData = new ArrayList<Observation>();
	
	/*
	 * int containing the total number of  observations
	 */
	final int NUMBER_OF_MISSING_OBSERVATIONS = 10;

	/*
	 *  Number of stations in the dataset
	 */
	Integer numberOfStations = new Integer(null);
	
	/*
	 *  Final variables for the data parameters
	 */
	final String TA9M = "TA9M";
	final String TAIR = "TAIR";
	final String SRAD = "SRAD";
	final String STID = "STID";
	final String PRES = "PRES";
	final String WSPD = "WSPD";
	
	/*	
	/*
	 *  Mesonet String
	 */
	final String MESONET = "Mesonet";
	
	/*
	 * String directory for the data file
	 */
	//String directory;
		
	/*
	 *  String for the fileName
	 */
	String fileName;
	
	/*
	 *  Declare GregorianCalendar
	 */
	GregorianCalendar utcDateTime;
	
	/**
	 * Constructor for the MapData Object
	 * 	
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param directory
	 * @throws IOException
	 */
	public MapData(int year, int month, int day, int hour, int minute, String directory) throws IOException {
		
		
		this.utcDateTime = new GregorianCalendar(year, month, day, hour, minute);
		fileName = createFileName(year, month, day, hour, minute, directory);
		//this.directory = directory;
		
		// Also create new ZonedDateTime
		
				
	}
	
	/**
	 *  Returns a string of the date with the format "data/YYYYMMDDHHMM.mdf"
	 *  
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param directory
	 * @return the created fileName with the given format
	 */
	public String createFileName(int year, int month, int day, int hour, int minute, String directory) {
		
		String fileName = String.format("%s/%04d%02d%02d%02d%02d.mdf", directory, year, month, day, hour, minute);
		
		return fileName;
	
	}
	
	/**
	 * Parses the header line of the data set
	 * 
	 * @param inParamStr
	 */
	private void parseParamHeader(String inParamStr) {
		
    
	    // String containing a header line
	 	String strg = inParamStr;
	 	
	    // Split string into array   
	    String[] columnHeaders = strg.trim().split("\\s+");
	    
	    for(int i = 0; i < columnHeaders.length; i++) {
	    	
	    	// If column header string equals data type string, set position to index
	    	if(columnHeaders[i].equalsIgnoreCase(TA9M)) {
	    		Integer value = new Integer(i);
	    		paramPositions.put(TA9M, i);
	    	}
	    	else if(columnHeaders[i].equalsIgnoreCase(TAIR)) {
	    		Integer value = new Integer(i);
	    		paramPositions.put(TAIR, value);
	    	}
	    	else if(columnHeaders[i].equalsIgnoreCase(SRAD)) {
	    		Integer value = new Integer(i);
	    		paramPositions.put(SRAD, value);
	    	}
	    	else if(columnHeaders[i].equalsIgnoreCase(STID)) {
	    		Integer value = new Integer(i);
	    		paramPositions.put(STID, value);
	    	}
		    else if(columnHeaders[i].equalsIgnoreCase(PRES)) {
		    		Integer value = new Integer(i);
		    		paramPositions.put(PRES, value);
		    }
	    	else if(columnHeaders[i].equalsIgnoreCase(WSPD)) {
	    		Integer value = new Integer(i);
	    		paramPositions.put(WSPD, value);

	    	}
	    	else;
	    }
	}
	
	public Integer getIndexOf(String inParamStr) {
		
		return paramPositions.get(inParamStr);
			
	}
	
	/**
	 * Parses the data file, fills in the ArrayList for the given data parameters
	 * 
	 * @throws IOException
	 */
	public void parseFile() throws IOException, ParseException {
		
		// String containing a line of data from the file.
		String strg;		
		String time;
		String header;
		
		// Read in MDF file
		BufferedReader br = new BufferedReader(new FileReader(fileName));		    
			    
		// Throw out first two lines
		strg = br.readLine();
		time = br.readLine();
		
		// Make date format
		utcDateTime = Statistics.createDateFromString(time.trim());

		// Read in third row containing header
		header = br.readLine();
			   
		
		strg = br.readLine();
		
		// Parse third row headers
		parseParamHeader(header);

			    
		// Keeps track of Null Pointer Exceptions when fillin in 
		// ArrayList from Collections class
		ArrayList<Observation> sradData = new ArrayList<Observation>();
		ArrayList<Observation> ta9mData = new ArrayList<Observation>();
		ArrayList<Observation> tairData = new ArrayList<Observation>();
		ArrayList<Observation> presData = new ArrayList<Observation>();
		ArrayList<Observation> wspdData = new ArrayList<Observation>();

		// Counter for while loop
		int i = 0;
			    
		// Loop over the file until the end			    
		while(strg != null) { 
			
			// Read next Line
			strg = br.readLine();
			
			// Split specified line of the file
			String[] mapData = strg.trim().split("\\s+");
				    	
		  	// Read in observation values for each iteration for each data parameter
	    	String stid = mapData[paramPositions.get(STID)];
	    	double tairValue = Double.parseDouble(mapData[paramPositions.get(TAIR)]);
	    	double sradValue = Double.parseDouble(mapData[paramPositions.get(SRAD)]);
	    	double ta9mValue = Double.parseDouble(mapData[paramPositions.get(TA9M)]);
	    	double presValue = Double.parseDouble(mapData[paramPositions.get(PRES)]);
	    	double wspdValue = Double.parseDouble(mapData[paramPositions.get(WSPD)]);
	    	
		   	Observation srad = new Observation(sradValue, stid);
		   	Observation ta9m = new Observation(ta9mValue, stid);
		   	Observation tair = new Observation(tairValue, stid);
		   	Observation pres = new Observation(presValue, stid);
		   	Observation wspd = new Observation(wspdValue, stid);

				    	
		   	// Add new observations to the specified ArrayList
		   	sradData.add(srad);
		  	ta9mData.add(ta9m);
		   	tairData.add(tair);
		   	wspdData.add(wspd);
		   	presData.add(pres);
				    			
				 
		   	// Increment counter, will give the number of stations
		   	++i;
		   	
		 }
		
		dataCatalog.put(SRAD, sradData);
		dataCatalog.put(TAIR, tairData);
		dataCatalog.put(TA9M, ta9mData);
		dataCatalog.put(WSPD, wspdData);
		dataCatalog.put(PRES, presData);


		 // Close the BufferedReader
		 br.close();
		 
		 String iString = String.format("%d", i);
		        
		 // Set numberOfStations to the number of iterations through while loop
		 numberOfStations = new Integer(iString);
			    
	}
	
	/**
	 * 
	 */
	private void calculateAllStatistics() {
		
		calculateStatistics();
		
		
	}

	/**
	 * 
	 */
	private void prepareDataCatalog() {
		// Not Sure about this
	}

	/**
	 * Calculate the Statistics for a given ArrayList of an Observation Object and the given data parameter
	 * 
	 * @param inData
	 * @param paramId
	 */
	private void calculateStatistics() {
		
		// Need to figure out what is the difference between this and calcAllStatistics
		
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		double average = 0;

		double totValidObs = 0;
		
		String stidMax = "";
		String stidMin = ""; 
		
		int counter = 0;
		
        TreeMap<String, Statistics> treemin = new TreeMap<String, Statistics>();   
        TreeMap<String, Statistics> treemax = new TreeMap<String, Statistics>();    
        TreeMap<String, Statistics> treeavg = new TreeMap<String, Statistics>();
        TreeMap<String, Statistics> treetot = new TreeMap<String, Statistics>();

        for (Map.Entry<String, ArrayList<Observation>> entry : dataCatalog.entrySet()) {         

        String mapKey = entry.getKey();
        ArrayList<Observation> mapValue = entry.getValue();

            
			for (int i = 0; i < mapValue.size(); i++) {
				
	
				if (mapValue.get(i).isValid()) {
					
					double indexVal = mapValue.get(i).getValue();
					String stidVal = mapValue.get(i).getStid();
					totValidObs = totValidObs + mapValue.get(i).getValue();
					
					if (max < indexVal) {
						max = indexVal;
						stidMax = stidVal;
					}
					else if (min > indexVal) {
						min = indexVal;
						stidMin = stidVal;
					}
					
					counter++;
				}
			}
			
			average = totValidObs / counter;
			
			// Make temp Statistic objects to store Statistics information
			Statistics averageStat = new Statistics(average, MESONET, this.utcDateTime, counter, StatsType.AVERAGE);
			Statistics maxStat = new Statistics(max, stidMax, this.utcDateTime, counter, StatsType.MAXIMUM);
			Statistics minStat = new Statistics(min, stidMin, this.utcDateTime, counter, StatsType.MINIMUM);
			Statistics totStat = new Statistics(totValidObs, MESONET, this.utcDateTime, counter, StatsType.TOTAL);
		
			
			treeavg.put(mapKey, averageStat);
			treemax.put(mapKey, maxStat);
			treemin.put(mapKey, minStat);
			treetot.put(mapKey, totStat);
			
			statistics.put(StatsType.AVERAGE, treeavg);
			statistics.put(StatsType.MAXIMUM, treemax);
			statistics.put(StatsType.MINIMUM, treemin);

		}
	}
			
/*			// Series of if statements, initialize Statistics object based on paramID
			// If block for srad paramId
			if (paramId.equalsIgnoreCase(SRAD)) {
				sradAverage = averageStat;
				sradMax = maxStat;
				sradMin = minStat;
				sradTotal = totStat;
			}
			
			// If block for ta9m paramId
			if (paramId.equalsIgnoreCase(TA9M)) {
				ta9mAverage = averageStat;
				ta9mMax = maxStat;
				ta9mMin = minStat;
			}
			
			// If block for tair paramId
			if (paramId.equalsIgnoreCase(TAIR)) {
				tairAverage = averageStat;
				tairMax = maxStat;
				tairMin = minStat;
			}			
		}
*/		

 
	public Statistics getStatistics(StatsType type, String paramID) {
		
		calculateAllStatistics();
		
		TreeMap<String, Statistics> tree = statistics.get(type);
		
		Statistics statTree = tree.get(paramID);
		
		return statTree;
	}
	
/*	*//**
	 * Overrides the Object toString, outputs String to specified format
	 * 
	 * @return String of the MapData Statistics in specified format 
	 *//*
	public String toString() {
		
		//Create String for return
		String tairString = "";
		String ta9mString = "";
		String sradString = "";
		String endString = "";
		
    	String equals = "========================================================\n";
    	
    	// Pad the int variables by making them Strings
    	String tairAvg = String.format("%.1f", );
    	String ta9mAvg = String.format("%.1f", );
    	String sradAvg = String.format("%.1f", );
    	
    	// Get date from GregorianCalendar Object
    	String date = "=== " + utcDateTime.getTime() + " ===\n";
    	
		// Format String for each data type
    	tairString = "Maximum Air Temperature[1.5m]: = " + tairMax.getValue() + " C at " + tairMax.getStid() + "\n"
    			    + "Minimum Air Temperature[1.5m]: = " + tairMin.getValue() + " C at " + tairMin.getStid() + "\n"
    			    + "Average Air Temperature[1.5m]: = " + tairAvg + " C at " + tairAverage.getStid() + "\n";
    	
    	ta9mString = "Maximum Air Temperature[9.0m]: = " + ta9mMax.getValue() + " C at " + ta9mMax.getStid() + "\n"
    			    + "Minimum Air Temperature[9.0m]: = " + ta9mMin.getValue() + " C at " + ta9mMin.getStid() + "\n"
    			    + "Average Air Temperature[9.0m]: = " + ta9mAvg + " C at " + ta9mAverage.getStid() + "\n";
    	
    	sradString = "Maximum Solar Radiation[1.5m]: = " + sradMax.getValue() + " W/m^2 at " + sradMax.getStid() + "\n"
    				+ "Minimum Solar Radiation[1.5m]: = " + sradMin.getValue() + " W/m^2 at " + sradMin.getStid() + "\n"
    				+ "Average Solar Radiation[1.5m]: = " + sradAvg + " W/m^2 at " + sradAverage.getStid() + "\n";
	
    	// Put all string together to get format
    	endString = equals + date + equals+ tairString + equals  + equals  + ta9mString + equals + equals + sradString + equals;
    	
    	return endString;

	}*/
	
}

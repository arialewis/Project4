package MapData;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
/**
 * 
 * @author Aria Lewis, Billy Lo
 *
 */
public class Statistics extends Observation implements DateTimeComparable  {
	
	// Enum might need to go here

	// Need to use this constant to set the format of the Calendar object date
	/** */
	protected final static String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss z";
	
	/** */
	protected DateTimeFormatter format;
	
	/** */
	private GregorianCalendar utcDateTime;
	
	/** */
	private ZonedDateTime zdtDateTime;
	
	/** */
	private int numberOfReportingStations;
	
	/** */
	private StatsType statType;
	

	/**
	 * 
	 * @param dateTimeStr
	 * @return
	 */
	public Statistics(double value, String stid, GregorianCalendar dateTime, int numberOfValidStations, StatsType inStatType) {
		
		// Set values
		super(value, stid);
		this.utcDateTime = dateTime;
		this.numberOfReportingStations = numberOfValidStations;
		this.statType = inStatType;
		
	}

	/**
	 * 
	 * @param dateTimeStr
	 * @return
	 */
	public Statistics(double value, String stid, ZonedDateTime dateTime, int numberOfValidStations, StatsType inStatType) {
		
		// Set values
		super(value, stid);
		this.zdtDateTime = dateTime;
		this.numberOfReportingStations = numberOfValidStations;
		this.statType = inStatType;
		
	}

	/**
	 * Creates GregorianCalendar date from String
	 * @param dateTimeStr string with date
	 * @return Gregorian Calendar
	 */
	public static GregorianCalendar createDateFromString(String dateTimeStr) throws ParseException {
		
		SimpleDateFormat date = new SimpleDateFormat(DATE_TIME_FORMAT);
		date.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		Date dateOb = date.parse(dateTimeStr.trim());
		
		GregorianCalendar dateGregCal = new GregorianCalendar();
		dateGregCal.setTimeZone(TimeZone.getTimeZone("UTC"));
		dateGregCal.setTime(dateOb);
		
		return dateGregCal;
		
	}
	
	/**
	 * Creates ZonedDateTime date from String
	 * @param dateTimeStr string with given date
	 * @return ZonedDateTime
	 */
	public ZonedDateTime createZDateFromString(String dateTimeStr) throws ParseException {
				
		ZonedDateTime dateZDT = ZonedDateTime.parse(dateTimeStr);
		
		return dateZDT;
		
	}

	/**
	 * Creates a date string from a GregorianCalendar object
	 * @param calendar GregorianCalendar object
	 * @return String contains date
	 */
	public String createStringFromDate(GregorianCalendar calendar) {
		
		// Return the toString of the GregorianCalendar date
		Date date = calendar.getTime();
		SimpleDateFormat dateSdt = new SimpleDateFormat(DATE_TIME_FORMAT);
		
		dateSdt.setCalendar(calendar);
		
		String utcDateString = dateSdt.format(date);
		
		return utcDateString;
	}

	/**
	 * Creates a date string from a ZonedDateTime object
	 * 
	 * @param calendar ZonedDateTime object
	 * @return String contains date
	 */
	public String createStringFromDate(ZonedDateTime calendar) {
				
		String zdtDateString = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT).format(calendar);
		
		return zdtDateString;
	}
	
	/**
	 * Returns the number of stations with data from the specified file
	 * 
	 * @return int the number of stations with data
	 */
	public int getNumberOfReportingStations() {
		
		return this.numberOfReportingStations;
	}
	
	/**
	 * 
	 * @return
	 */
	// Check logic
	public String getUTCDateTimeString() {
		
		// Return string from class createStringFromDate method
		String utcDateTime = createStringFromDate(this.utcDateTime);
		return utcDateTime;
	}
	
	/**
	 * 
	 * @return true/false return if the first argument is newer than the second argument
	 */
	public boolean newerThan(GregorianCalendar inDateTime) {
		
		// Create boolean variable for return
		return inDateTime.after(utcDateTime);
	}
	
	/**
	 * @return true/false return if the first argument is older than the second argument
	 */
	public boolean olderThan(GregorianCalendar inDateTime) {
		
		// Create boolean variable for return
		return inDateTime.before(utcDateTime);
	}
	
	/**
	 * 
	 * @return true/false return if the first argument is the same as than the second argument
	 */
	public boolean sameAs(GregorianCalendar inDateTime) {
		
		// Create boolean variable for return
		return inDateTime.after(utcDateTime);
		
	}

	/**
	 * 
	 * @return true/false return if the first argument is newer than the second argument
	 */
	public boolean newerThan(ZonedDateTime inDateTime) {
		
		String givenDate = createStringFromDate(inDateTime);
		
		this.format = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
		
		this.zdtDateTime = ZonedDateTime.parse(givenDate, format.withZone(ZoneId.systemDefault()));

		// Create boolean variable for return
		return inDateTime.isAfter(zdtDateTime);
	}
	
	/**
	 * @return true/false return if the first argument is older than the second argument
	 */
	public boolean olderThan(ZonedDateTime inDateTime) {
		
		String givenDate = createStringFromDate(inDateTime);
		this.format = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
		
		this.zdtDateTime = ZonedDateTime.parse(givenDate, format.withZone(ZoneId.systemDefault()));

		// Create boolean variable for return
		return inDateTime.isBefore(zdtDateTime);
	}
	
	/**
	 * 
	 * @return true/false return if the first argument is the same as than the second argument
	 */
	public boolean sameAs(ZonedDateTime inDateTime) {
		
		String givenDate = createStringFromDate(inDateTime);
		this.format = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
		
		this.zdtDateTime = ZonedDateTime.parse(givenDate, format.withZone(ZoneId.systemDefault()));

		// Create boolean variable for return
		return inDateTime.isAfter(zdtDateTime);
		
	}

	/**
	 * 
	 * @return
	 */
	public String toString() {
		
		return super.toString();
	}
}


package MapData;
import java.util.GregorianCalendar;
import java.time.ZonedDateTime;

/**
* @author Aria Lewis
* @version 10/18/2018
* 
* Project 3
* 
* Comparable interface for Gregorian Calendar and ZonedDateTime
*/

public interface DateTimeComparable {

	boolean newerThan(GregorianCalendar inDateTimeUTC);
	boolean olderThan(GregorianCalendar inDateTimeUTC);
	boolean sameAs(GregorianCalendar inDateTimeUTC);
	boolean newerThan(ZonedDateTime inDateTimeUTC);
	boolean olderThan(ZonedDateTime inDateTimeUTC);
	boolean sameAs(ZonedDateTime inDateTimeUTC);		

}

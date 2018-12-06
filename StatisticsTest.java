import java.text.ParseException;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

/**
* @author Aria Lewis
* @version 10/18/2018
* 
* Project 3
* 
* Unit Test for Statistics class
*/

public class StatisticsTest {

	// If other methods pass then the Constructor is correct
	//public void testStatisticsDoubleStringStringIntStatsType()

	// If other methods pass then the Constructor is correct
	// Public void testStatisticsDoubleStringGregorianCalendarIntStatsType()

	
	// ADD ZONEDDATETIME TESTS AND DOCUMENTATION
	
	/**
	 * Creates a GregorianCalendar from Statistics Object with a given string 
	 * 
	 * @throws java.text.ParseException
	 */	
	@Test
	public void testCreateDateFromString() throws java.text.ParseException {

		GregorianCalendar gc = new GregorianCalendar(2018, 8, 30, 17, 45);
		
		StatsType inStatsType = StatsType.AVERAGE;
	
		Statistics statgc = new Statistics(2.2, "stid", gc, 100, inStatsType);
		
	    String time = "2120180801"; // print output from time string in the actual method to 
		Assert.assertEquals(gc, statgc.createDateFromString(time));
		
	}

	/**
	 * Creates a ZonedDateTime from Statistics Object with a given string 
	 * 
	 * @throws java.text.ParseException
	 */
	@Test
	public void testCreateZDateFromString() throws java.text.ParseException {

		String time = "2120180801"; // print output from time string in the actual method to 
		
		ZonedDateTime zdt = ZonedDateTime.parse(time);
		
		StatsType inStatsType = StatsType.AVERAGE;
	
		Statistics statzdt = new Statistics(2.2, "stid", zdt, 100, inStatsType);
		
	    Assert.assertEquals(zdt, statzdt.createDateFromString(time));
	}

	/**
	 * Creates a time String from Statistics Object from a GregorianCalendar
	 * 
	 * @throws java.text.ParseException
	 */
	@Test
	public void testCreateStringFromDate() {
	
		GregorianCalendar gc = new GregorianCalendar(2018, 8, 30, 17, 45);
		
		StatsType inStatsType = StatsType.AVERAGE;
		
		Statistics statgc = new Statistics(2.2, "stid", gc, 100, inStatsType);
		
		String dateString = "Sun Sep 30 17:45:00 CDT 2018";
		
		Assert.assertEquals(dateString, statgc.createStringFromDate(gc));

	}
	
	/**
	 * Creates a time String from Statistics Object from a ZonedDate
	 * 
	 * @throws java.text.ParseException
	 */
	@Test
	public void testZCreateStringFromDate() { //date from string
		
		String zdtDateString = "2018-8-30T17:45:00+01:00[Europe/Paris]";
		String dateString = "Sun Sep 30 17:45:00 CDT 2018";
		
		ZonedDateTime zdt = ZonedDateTime.parse(zdtDateString);
		
		StatsType inStatsType = StatsType.AVERAGE;
		
		Statistics statzdt = new Statistics(2.2, "stid", zdt, 100, inStatsType);
		
		Assert.assertEquals(dateString, statzdt.createStringFromDate(zdt));

	}

	/**
	 *  Test the correct number of working stations
	 */
	@Test
	public void testGetNumberOfReportingStations() {
	
		GregorianCalendar gc = new GregorianCalendar(2018, 8, 30, 17, 45);		
		StatsType inStatsType = StatsType.AVERAGE;
		Statistics stat = new Statistics(2.2, "stid", gc, 100, inStatsType);	

		Assert.assertTrue(stat.getNumberOfReportingStations() == 1);
	}

	/**
	 * 
	 * Test that the correct UTC date string is made from Statistics Object
	 */
	@Test
	public void testGetUTCDateTimeString() {
		
		GregorianCalendar gc = new GregorianCalendar(2018, 8, 30, 17, 45);
		StatsType inStatsType = StatsType.AVERAGE;
		Statistics stat = new Statistics(0, null, gc, 0, inStatsType);	
	
		String utc = "Sun Sep 30 17:45:00 CDT 2018";
		Assert.assertEquals(utc, stat.getUTCDateTimeString());
	}
	
	/**
	 * 
	 * Test the newer than comparable method for GregorianCalendar and ZonedDateTime
	 */	
	@Test
	public void testNewerThan() throws ParseException {
		
		StatsType inStatsType = StatsType.AVERAGE;
		
		GregorianCalendar gc = new GregorianCalendar(2018, 8, 6, 6, 48);
		GregorianCalendar gc2 = new GregorianCalendar(2018, 9, 6, 6, 48);
	
		Statistics statgc = new Statistics(0, null, gc, 1, inStatsType);
		
		ZonedDateTime zd = ZonedDateTime.parse("201808060648");
		ZonedDateTime zd2 = ZonedDateTime.parse("201809060648");
		
		Statistics statzd = new Statistics(0, null, zd, 1, inStatsType);
		
		Assert.assertTrue(statgc.olderThan(gc2));
		Assert.assertTrue(statzd.olderThan(zd2));
	}

	/**
	 * 
	 * Test the older than comparable method for GregorianCalendar and ZonedDateTime
	 */
	@Test
	public void testOlderThan() throws ParseException {

		StatsType inStatsType = StatsType.AVERAGE;
		
		GregorianCalendar gc = new GregorianCalendar(2018, 9, 6, 6, 48);
		GregorianCalendar gc2 = new GregorianCalendar(2018, 8, 6, 6, 48);
	
		Statistics statgc = new Statistics(0, null, gc, 1, inStatsType);
		
		ZonedDateTime zd = ZonedDateTime.parse("201809060648");
		ZonedDateTime zd2 = ZonedDateTime.parse("201808060648");
		
		Statistics statzd = new Statistics(0, null, zd, 1, inStatsType);
		
		Assert.assertTrue(statgc.olderThan(gc2));
		Assert.assertTrue(statzd.olderThan(zd2));
	}

	/**
	 * 
	 * Test the same than comparable method for GregorianCalendar and ZonedDateTime
	 */
	@Test
	public void testSameAs() throws ParseException {

		StatsType inStatsType = StatsType.AVERAGE;
		
		GregorianCalendar gc = new GregorianCalendar(2018, 8, 6, 6, 48);
		GregorianCalendar gc2 = new GregorianCalendar(2018, 8, 6, 6, 48);
	
		Statistics statgc = new Statistics(0, null, gc, 1, inStatsType);
		
		ZonedDateTime zd = ZonedDateTime.parse("201808060648");
		ZonedDateTime zd2 = ZonedDateTime.parse("201808060648");
		
		Statistics statzd = new Statistics(0, null, zd, 1, inStatsType);
		
		Assert.assertTrue(statgc.sameAs(gc2));
		Assert.assertTrue(statzd.sameAs(zd2));

	}

	
	@Test
	public void testToString() {
		
		Observation obsTest = new Observation(639, "ALV2");
			
		String expected = "639 at ALV2";
			
		Assert.assertEquals(expected, obsTest.toString());
		
	}

}

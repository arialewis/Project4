import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Aria Lewis
 * @version 2018-10-05
 * 
 * Junit test for the MapData class
 */


public class MapDataTest {

	// @Test
	// Public void MapDataTest()
	// Constructor is correct if other tests pass
		
	
	int year = 2018;
	int month = 8;
	int day = 30;
	int hour = 17;
	int minute = 45;
	String directory = "data";
	

	/**
	 * Test createFileName method from MapData
	 */
	@Test 
	public void createFileNameTest() throws IOException {
		
		MapData test = new MapData(year, month, day, hour, minute, "data");

		String exp = "data/201808301745.mdf";
		
		Assert.assertEquals(exp, test.createFileName(year, month, day, hour, minute, "data"));
	
	}
	
	// @Test
	// public void parseParamHeaderTest()
	// Test is successful if other tests pass

	/**
	 * Test getIndexOf method from MapData
	 * @throws IOException 
	 */
	@Test
	public void getIndexOfTest() throws IOException {
		
		MapData test = new MapData(year, month, day, hour, minute, "data");
		
		Integer exp = new Integer (4);
		
		Assert.assertEquals(exp, test.getIndexOf("TAIR"));
	}

	
	/**
	 * Test parseFile method from MapData
	 */
	@Test
	public void parseFileTest() {
		// Make sure that the arrays are not empty
		// cp 
	}
	

	/**
	 * 
	 * Test getStatistics
	 * @throws IOException 
	 */
	@Test
	public void getStatisticsTest() throws IOException { // SRAD has total
		
		MapData mapDataTest = new MapData(2018, 8, 30, 17, 45, "data"); 
		
		String sradMin = "163.0 at MIAM";
		String sradMax = "968.0 at SLAP";
		String sradAverage = "835.2 at Mesonet";
		String sradTotal = "0"; // See what the answer is after running method
		
		Assert.assertEquals(sradMin, mapDataTest.getStatistics(StatsType.MINIMUM,"SRAD"));
		Assert.assertEquals(sradMax, mapDataTest.getStatistics(StatsType.MAXIMUM,"SRAD"));
		Assert.assertEquals(sradAverage, mapDataTest.getStatistics(StatsType.AVERAGE,"SRAD"));
		Assert.assertEquals(sradTotal, mapDataTest.getStatistics(StatsType.TOTAL,"SRAD"));
		
	}
	
	/**
	 * Test the toString method for MapData
	 * 
	 */
	@Test
	public void testToString() throws IOException {

		MapData mapDataTest = new MapData(2018, 8, 30, 17, 45, "data"); 
		
		String expectedString = "========================================================\r\n" + 
				"=== 2018-08-30 17:45 ===\r\n" + 
				"========================================================\r\n" + 
				"Maximum Air Temperature[1.5m]: = 36.5 C at HOOK\r\n" + 
				"Minimum Air Temperature[1.5m]: = 20.8 C at MIAM\r\n" + 
				"Average Air Temperature[1.5m]: = 32.7 C at Mesonet\r\n" + 
				"========================================================\r\n" + 
				"========================================================\r\n" + 
				"Maximum Air Temperature[9.0m]: = 34.9 C at HOOK\r\n" + 
				"Minimum Air Temperature[9.0m]: = 20.7 C at MIAM\r\n" + 
				"Average Air Temperature[9.0m]: = 31.8 C at Mesonet\r\n" + 
				"========================================================\r\n" + 
				"========================================================\r\n" + 
				"Maximum Solar Radiation[1.5m]: = 968.0 W/m^2 at SLAP\r\n" + 
				"Minimum Solar Radiation[1.5m]: = 163.0 W/m^2 at MIAM\r\n" + 
				"Average Solar Radiation[1.5m]: = 835.2 W/m^2 at Mesonet\r\n" + 
				"========================================================";
		
		Assert.assertEquals(expectedString, mapDataTest.toString());
		
	}

}

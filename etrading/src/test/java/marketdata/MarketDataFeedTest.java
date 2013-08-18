package marketdata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import common.Logger;
import common.Timer;

public class MarketDataFeedTest {
	private Logger logger = Logger.getInstance(MarketDataFeedTest.class);
	
	@Before
	public void init() {
		logger.showReadableTime(true);
		logger.setDebug(true);
	}
	
	@Test
	public void priceTest() {
		Timer.start("price");
		MarketDataFeed feed = new MarketDataFeed();
		for (int i = 0; i < 10000; i++) {
			double price = feed.getPrice("IBM",  100,  120);
			logger.info("price:"+price);
			assertTrue(price >= 100D && price < 121D);
		}	
		logger.info(Timer.endSecs("price"));
		
	}
}

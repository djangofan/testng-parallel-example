package qa.testng.test;

import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class ParallelDataProvider1Test {	
	
	int n;
	long threadId;

	@Factory(dataProvider = "factory", dataProviderClass = TestProvider.class)
	public ParallelDataProvider1Test( int n ) {
		this.n = n;
	}

	@BeforeTest
	public void before() {
		threadId = Thread.currentThread().getId();
	}

	@Test(dataProvider = "provide", dataProviderClass = TestProvider.class)
	public void checkCME1( final Integer i ) {
		Reporter.log( "{" + this.getClass().getSimpleName() + "} Thread-" + threadId + "[" + n + "]: " + i, true );
		waitFor(25);
	}

	public void waitFor(long wait) {
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
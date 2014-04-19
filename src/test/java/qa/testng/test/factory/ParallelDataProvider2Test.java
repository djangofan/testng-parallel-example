package qa.testng.test.factory;

import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.testng.test.TestProvider;

public class ParallelDataProvider2Test {	
	
	String num;
	long threadId;

	public ParallelDataProvider2Test( String num ) {
		this.num = num;
	}

	@BeforeTest
	public void before() {
		threadId = Thread.currentThread().getId();
	}

	@Test(dataProvider = "provide", dataProviderClass = TestProvider.class)
	public void checkCME1( final Integer i ) {
		Reporter.log( "{" + this.getClass().getSimpleName() + "} Thread-" + threadId + "[" + num + "]: " + i, true );
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
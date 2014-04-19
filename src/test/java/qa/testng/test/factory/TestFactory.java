package qa.testng.test.factory;

import org.testng.annotations.Factory;

public class TestFactory {
	
	@Factory
	public Object[] getStrings() {
		Object[] result = new Object[10];
		for ( int i = 0; i < 10; i++ ) {
			result[i] = new ParallelDataProvider2Test(Integer.toString(i));
		}
		return result;
	}
	
}

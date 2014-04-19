package qa.testng.test;

import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.collections.Lists;

public class TestProvider {

	@DataProvider(parallel = true, name = "provide")
	static Iterator<Integer[]> provide() {
		final List<Integer[]> ret = Lists.newArrayList();
		for (int i = 0; i < 10; i++) {
			ret.add(new Integer[] { i });
		}
		return ret.iterator();
	}

	@DataProvider(name = "factory")
	static public Object[][] factory() {
		return new Object[][] {
				new Object[] { 41 },
				new Object[] { 42 },
				new Object[] { 43 },
				new Object[] { 44 },
				new Object[] { 45 },
		};
	}
	
}

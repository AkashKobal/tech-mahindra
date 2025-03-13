package UnitTest;


import org.junit.jupiter.api.Test;

class TestRunnerTest {

	@Test
	void testMain() throws Exception {
		// given
		String[] args = new String[]{"TestArgs"};
		// when
		TestRunner.main(args);
		// then
		// TODO check for expected side effect (i.e. service call, changed parameter or exception thrown)
		// verify(mock).methodcall();
		// TestUtils.assertTestFileEquals("someMethod/ParamType_updated.json", TestUtils.objectToJson(param));
		// assertThrows(SomeException.class, () -> underTest.someMethod());
	}

}
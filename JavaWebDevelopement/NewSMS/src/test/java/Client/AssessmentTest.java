package Client;


import static org.assertj.core.api.Assertions.assertThat;
import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;

@ExtendWith(MockitoExtension.class)
class AssessmentTest {

	@InjectMocks
	Assessment underTest;

	@Test
	void testArea() throws Exception {
		// given
		int a = 123;
		int b = 123;
		// when
		double actual=underTest.area(a, b);
		// then
		assertThat(actual).isEqualTo(12.34);
	}

	@Test
	void testArea_1() throws Exception {
		// given
		int b = 123;
		int h = 123;
		// when
		double actual=underTest.area(b, h);
		// then
		assertThat(actual).isEqualTo(12.34);
	}

	@Test
	void testMain() throws Exception {
		// given
		String[] args = new String[]{"TestArgs"};
		// when
		Assessment.main(args);
		// then
		// TODO check for expected side effect (i.e. service call, changed parameter or exception thrown)
		// verify(mock).methodcall();
		// TestUtils.assertTestFileEquals("someMethod/ParamType_updated.json", TestUtils.objectToJson(param));
		// assertThrows(SomeException.class, () -> underTest.someMethod());
	}

}
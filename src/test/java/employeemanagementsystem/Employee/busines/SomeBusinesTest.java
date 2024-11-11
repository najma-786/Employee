package employeemanagementsystem.Employee.busines;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SomeBusinesTest {
	
	@Test
	public void calculateSum_basic() {
		SomeBusinesImpl business=new SomeBusinesImpl();
		int actualResult=business.calculateSum(new int[] {1,2,3});
		int expectedResult=8;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void calculateSum_empty() {
		SomeBusinesImpl business=new SomeBusinesImpl();
		int actualResult=business.calculateSum(new int[] {});
		int expectedResult=0;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void calculateSum_oneValue() {
		SomeBusinesImpl business=new SomeBusinesImpl();
		int actualResult=business.calculateSum(new int[] {5});
		int expectedResult=5;
		assertEquals(expectedResult, actualResult);
	}

}

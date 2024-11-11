package employeemanagementsystem.Employee.busines;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import employeemanagementsystem.Employee.service.SomeDataService;



class SomeDataServiceStubBasic implements SomeDataService
{

	@Override
	public int[] retriveAllData() {
		// TODO Auto-generated method stub
		return new int[] {1,2,3};
	}
	
}
class SomeDataServiceStubEmpty implements SomeDataService
{

	@Override
	public int[] retriveAllData() {
		// TODO Auto-generated method stub
		return new int[] {};
	}
	
}
class SomeDataServiceStubOneValue implements SomeDataService
{

	@Override
	public int[] retriveAllData() {
		// TODO Auto-generated method stub
		return new int[] {5};
	}
	
}
public class SomeBusinesStubTest {
	
	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinesImpl business=new SomeBusinesImpl();
		//business.setSomeDataService(someDataService);it directly tacking to the database
//	      if we do not want to tack to database directly so if somebody changing the database that 
//		will lead to problem 
		//so your unit test should not be depend on anything outside
		//we can use SomeDataServiceStub class 
		//below disadvantages 
		// if we add any new methods added to SomeDataService then it will throw compilation error
		//we have to write multiple stub classes to implement SomeDataService interface	
		//To avoid above disadvantages we can use Mockito 
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		//dataServiceMock retriveAllData new int[] {1,2,3}
		//instead of stub when retriveAllData() is called then return new int[] {1,2,3}
		when(dataServiceMock.retriveAllData()).thenReturn(new int[] {1,2,3});
		
		//business.setSomeDataService(new SomeDataServiceStubBasic());
		//then we are setting mock into the business service then calling the methods
		business.setSomeDataService(dataServiceMock);
		int actualResult=business.calculateSumUsingDataService();
		int expectedResult=6;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void calculateSumUsingDataService_empty() {
		SomeBusinesImpl business=new SomeBusinesImpl();
		SomeDataService dataServiceMock1 = mock(SomeDataService.class);
		when(dataServiceMock1.retriveAllData()).thenReturn(new int[] {});
		//business.setSomeDataService(new SomeDataServiceStubEmpty());
		business.setSomeDataService(dataServiceMock1);
		int actualResult=business.calculateSumUsingDataService();
		int expectedResult=0;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void calculateSumUsingDataService_oneValue() {
		SomeBusinesImpl business=new SomeBusinesImpl();
		SomeDataService dataServiceMock2 = mock(SomeDataService.class);
		when(dataServiceMock2.retriveAllData()).thenReturn(new int[] {5});
		//business.setSomeDataService(new SomeDataServiceStubOneValue());
		business.setSomeDataService(dataServiceMock2);
		int actualResult=business.calculateSumUsingDataService();
		int expectedResult=5;
		assertEquals(expectedResult, actualResult);
	}

}

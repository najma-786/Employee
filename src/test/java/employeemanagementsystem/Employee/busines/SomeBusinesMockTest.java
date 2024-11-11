package employeemanagementsystem.Employee.busines;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import employeemanagementsystem.Employee.service.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinesMockTest {
	
	
	@InjectMocks
	SomeBusinesImpl business=new SomeBusinesImpl();
	//SomeDataService dataService=mock(SomeDataService.class);
	
	@Mock
	SomeDataService dataService;
	
	@Test
	public void calculateSumUsingDataService_basic() {
		when(dataService.retriveAllData()).thenReturn(new int[] {1,2,3});
		assertEquals(6, business.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingDataService_empty() {
		when(dataService.retriveAllData()).thenReturn(new int[] {});
        assertEquals(0,business.calculateSumUsingDataService());
	}
	@Test
	public void calculateSumUsingDataService_oneValue() {
		when(dataService.retriveAllData()).thenReturn(new int[] {5});
		assertEquals(5, business.calculateSumUsingDataService());
	}

}

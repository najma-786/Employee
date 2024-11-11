package employeemanagementsystem.Employee.busines;

import employeemanagementsystem.Employee.service.SomeDataService;

public class SomeBusinesImpl {
	
	private SomeDataService someDataService;
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {
		int sum=0;
		for(int value:data) {
			sum+=value;
		}
		return sum;
	}
	
	public int calculateSumUsingDataService() {
		int sum=0;
		int[] data=someDataService.retriveAllData();
		for(int value:data) {
			sum+=value;
		}
		return sum;
	}

}

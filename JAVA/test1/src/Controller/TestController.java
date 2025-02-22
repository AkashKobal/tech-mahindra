package Controller;

import Model.TestModel;
import Repositiry.TestRepository;
import Service.TestServiceIMPL;

public class TestController {
	
	private TestServiceIMPL service;
	
	public TestController(TestServiceIMPL testService) {
		this.service = testService;
    }
	
	public int insertTest(TestModel t) {
		return service.insertTest(t);
		
	}
	

}

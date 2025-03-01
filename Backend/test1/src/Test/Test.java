package Test;

import Configuration.MySqlConnection;
import Controller.TestController;
import Model.TestModel;
import Repositiry.TestRepository;
import Service.TestServiceIMPL;

public class Test {
	public static void main(String[] args) {
		try {
			MySqlConnection mySqlConnection = new MySqlConnection();
			TestRepository testRepository = new TestRepository(mySqlConnection);
			TestServiceIMPL testServiceIMPL = new TestServiceIMPL(testRepository);
			TestController testController = new TestController(testServiceIMPL);
			
			TestModel testModel = new TestModel(7, "Test");
			int result = testController.insertTest(testModel);
			System.out.println("Result value = "+result);
			
			
			if(result == 1) {
                System.out.println("Test Inserted");
                	} else {
                		System.out.println("Failed to insert Test");
                	}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}

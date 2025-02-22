package Service;

import Model.TestModel;
import Repositiry.TestRepository;

public class TestServiceIMPL {
	
	// Constructor for Dependency Injection
	// inserting TestModel object  t in the database and returning the  number of rows affected
	// using serviceIMPL (service implementation) to insert the test object
	// if t is null, return 0
	// if t is not null, return 1
	// Ensure repository is properly initialized
	
	private TestRepository repository;

	public TestServiceIMPL(TestRepository repository) {
		this.repository = repository;
	}
	
	public int insertTest(TestModel t) {
		return repository.insertTest(t);
	}

}

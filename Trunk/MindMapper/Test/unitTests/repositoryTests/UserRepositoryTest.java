package unitTests.repositoryTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.automindmap.models.User;
import com.automindmap.repositories.UnitOfWork;

public class UserRepositoryTest {
	UnitOfWork _unitofwork= new UnitOfWork();

	@Test
	public void testAddUser() {
		User user=new User();
		user.userName="Milinau";		

		assertTrue("User adding oK",_unitofwork.user.addUser(user)>1);
		assertEquals("User deletedexpected",1,_unitofwork.user.deleteUser(user.userName));

	}

}

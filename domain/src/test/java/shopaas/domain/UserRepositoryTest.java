package shopaas.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = { "classpath:/META-INF/user-test-context.xml" })
public class UserRepositoryTest extends AbstractRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testFindByUsername() {
		User aUser = userRepository.findByUsername("rob");
		assertEquals("0001", aUser.getId());
		assertEquals("Robert", aUser.getName());
		assertEquals("Smith", aUser.getSurname());
	}
}
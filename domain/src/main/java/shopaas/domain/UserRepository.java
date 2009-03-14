package shopaas.domain;

public interface UserRepository {

	/**
	 * If more than one username is found, an exception should
	 * be raised.
	 * 
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

}

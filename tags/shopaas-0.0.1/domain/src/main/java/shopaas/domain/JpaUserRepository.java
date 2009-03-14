package shopaas.domain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepository implements UserRepository {

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public User findByUsername(final String username) {
		return (User) getEntityManager().createQuery(
				"from User where username = :username").setParameter(
				"username", username).getSingleResult();
	}

}
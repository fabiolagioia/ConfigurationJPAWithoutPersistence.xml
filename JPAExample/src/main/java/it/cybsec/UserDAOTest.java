package it.cybsec;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import it.cybsec.configuration.ConfigurationJPA;

public class UserDAOTest {
	
	static EntityManagerFactory factory; 
	static EntityManager entityManager;
	private static UserDAOTest dao;
	ConfigurationJPA confJpa = new ConfigurationJPA();
	
	private UserDAOTest(){
		factory= confJpa.createEntityManagerFactory();
		entityManager = factory.createEntityManager();
	}
	
	public static UserDAOTest getInstance() {
		if(factory == null)
			dao = new UserDAOTest();
		return dao;
	}
	

	public void addUser(User user) {
		entityManager.getTransaction().begin();
		entityManager.merge(user);
		entityManager.getTransaction().commit();
	}
	
	public void deleteUser(Integer id)
	{
		entityManager.getTransaction().begin();	
		entityManager.remove(entityManager.find(User.class, id)); 
		entityManager.getTransaction().commit();
	}
	
	
	public List<User> getAllUsers(){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		
		Root<User> user = cq.from(User.class);
		cq.select(user);
		TypedQuery<User> q = entityManager.createQuery(cq);
		List<User> allUsers = q.getResultList();
		return allUsers;
		
		
	}
	public static void main(String[] args) {
		UserDAOTest dao = UserDAOTest.getInstance();
		for(User u : dao.getAllUsers())
			System.out.print(u.getFullname());
	}
		

}

package com.springBoot.restClient.testDao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.springBoot.restClient.dao.UserRepository;
import com.springBoot.restClient.model.User;

@SpringBootTest
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository userRepository;
	
	User user = new User("Dupont","password",1);
	
	@BeforeEach
	public void setup() {
		entityManager.persist(user);
		entityManager.flush();
	}
	
	@Test
	public void findAllUser() {
		List<User>user=userRepository.findAll();
		
		//assertThat(4,user.size());	
	}
	
	@Test
	public void testSaveUser() {
	
		User user = new User("Paul","password",1);
		User userSaved = userRepository.save(user);
		assertNotNull(userSaved.getId());
	}
	
	
	
	

}

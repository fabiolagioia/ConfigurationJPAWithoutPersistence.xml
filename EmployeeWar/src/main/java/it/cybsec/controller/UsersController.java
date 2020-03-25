package it.cybsec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.cybsec.UserDAOTest;
import it.cybsec.User;

@RestController
@RequestMapping("/users")
public class UsersController {

	UserDAOTest dao = UserDAOTest.getInstance();
	

	
	
	@GetMapping("/getAllJar")
	public List<User> getAllJar(){
		return this.dao.getAllUsers();
	}
	
	/*
	@GetMapping("/getAllWar")
	public List<it.cybsec.model.User> getAllWar(){
		return this.repo.findAll();
	}
	*/

	@PostMapping("/post")
	public void insertUser(@RequestBody User user) {
		this.dao.addUser(user);
	}
	
	@PostMapping("/postWar")
	public void insertUserWar(@RequestBody User user) {
		this.dao.addUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id)
	{
		dao.deleteUser(id);
	}



}

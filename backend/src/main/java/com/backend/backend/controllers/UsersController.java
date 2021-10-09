package com.backend.backend.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.backend.entity.models.User;
import com.backend.backend.entity.services.IUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class UsersController {

	@Autowired
	IUserService iUsersService;

	@GetMapping("/users")
	List<User> getAll() {
		List<User> users =new ArrayList<User>(iUsersService.getAll());
		for (int i = 0; i < users.size(); i++) {
			users.get(i).setPassword("");
		}
		return users;
	}

	@GetMapping("/users/{email}")
	User getOne(@PathVariable("email") String email) {
		Optional<User> b = iUsersService.getOne(email);

		if (b.isPresent()) {
			b.get().setPassword("");
			return b.get();
		}
		;
		return null;
	}

	@PostMapping(value = "/users", consumes = "application/json")
	void add(@RequestBody String userString) {
		ObjectMapper om = new ObjectMapper();
		try {
			User user = om.readValue(userString, User.class);
			
			System.out.println(user.getEmail());
			iUsersService.add(user);
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
	}

	@PutMapping(value = "/users/{mail}", consumes = "application/json")
	void update(@RequestBody String userString, @PathVariable String mail) {
		ObjectMapper om = new ObjectMapper();
		try {
			User newUser = om.readValue(userString, User.class);
			Optional<User> user = iUsersService.getOne(mail);
			user.get().setName(newUser.getName());
			user.get().setPassword(newUser.getPassword());
			user.get().setAccess(newUser.getAccess());
			
			iUsersService.add(user.get());

		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}

	}

	@DeleteMapping("/users/{mail}")
	void delete(@PathVariable("mail") String mail) {
		iUsersService.delete(mail);
	}

}

package com.backend.backend.entity.services;
import java.util.List;
import java.util.Optional;

import com.backend.backend.entity.models.User;

public interface IUserService {
	List<User> getAll();
	Optional<User> getOne(String email);
	void add(User user);
	void delete(String email);
}

package com.backend.backend.entity.services;

import java.util.List;
import java.util.Optional;

import com.backend.backend.entity.dao.IUsersDao;
import com.backend.backend.entity.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUsersDao iUsersDao;

	@Override
	public List<User> getAll() {
		return (List<User>) iUsersDao.findAll();
		
	}

	@Override
	public void add(User user) {
		iUsersDao.save(user);
	}

	@Override
	public void delete(String user) {
		iUsersDao.deleteById(user);
	}

	@Override
	public Optional<User> getOne(String email) {
		return iUsersDao.findById(email);
	}
}

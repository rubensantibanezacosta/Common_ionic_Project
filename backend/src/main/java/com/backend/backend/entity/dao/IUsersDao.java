package com.backend.backend.entity.dao;

import com.backend.backend.entity.models.User;

import org.springframework.data.repository.CrudRepository;

public interface IUsersDao extends CrudRepository<User, String>{


}

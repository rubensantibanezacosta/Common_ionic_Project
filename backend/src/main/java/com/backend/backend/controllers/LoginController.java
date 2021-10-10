package com.backend.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.entity.services.ILoginService;
import com.backend.backend.entity.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class LoginController {
    String response = "empty";
    @Autowired
    ILoginService iloginService;

    @PostMapping(value = "/login", consumes = "application/json")
	@ResponseBody
    public String response(@RequestBody String userString) {
        User user=new User();
        
		ObjectMapper om = new ObjectMapper();
		try {
			user = om.readValue(userString, User.class);
            
			response= iloginService.login(user);
            
            
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		} 
        return response;     
	}
}

package com.backend.backend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.backend.entity.models.ContactInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class ContactInfoController {
    @PostMapping(value = "/contact", consumes = "application/json")
    @ResponseBody
    boolean nothing(@RequestBody String stringContactInfo) {
        ObjectMapper om = new ObjectMapper();
        try {
            ContactInfo contactInfo = om.readValue(stringContactInfo, ContactInfo.class);
            System.out.println(contactInfo.toString());
            
        } catch (JsonMappingException e) {

            e.printStackTrace();
        } catch (JsonProcessingException e) {

            e.printStackTrace();
        }
        return true;
    }
}

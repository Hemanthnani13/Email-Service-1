package com.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.entity.Email;
import com.in.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService service;
	
	@PostMapping("/schedule")
	public Email scheduleEmail(@RequestBody Email email) {
		return service.scheduleEmail(email);
	}
	
	@GetMapping("/getAll")
	public List<Email> getAll(){
		return service.getAll();
	}
	@GetMapping("/send")
	public String send() {
		service.sendMail("venkatesharnipalli3@gmail.com", "Test Mail", "Hello Mr.Perfert Praveen");
		return "Send Successfully";
	}
}

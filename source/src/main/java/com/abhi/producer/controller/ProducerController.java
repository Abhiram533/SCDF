package com.abhi.producer.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abhi.producer.model.User;
import com.abhi.producer.service.ProducerService;

@RestController
@RequestMapping("/")
public class ProducerController {
	
	@Autowired
	private ProducerService producerService;
	
	@PostMapping("/upload")
	public User saveToStage(@RequestParam("filename") MultipartFile file) throws IOException {
		User user=new User();
		if(file!=null || !file.isEmpty()) {
			user=producerService.saveToStage(file);
		}
		return user;
	}
	

}

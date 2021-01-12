package com.abhi.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.consumer.service.ConsumerService;
@RestController
@RequestMapping("/")
public class ConsumerController {
	@Autowired
	private ConsumerService consumerService;
	@RequestMapping("/save")
	public String save() {
		return consumerService.save();
	}
}

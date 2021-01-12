package com.abhi.processor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.processor.mode.Takara;
import com.abhi.processor.mode.User;
import com.abhi.processor.service.ProcessorService;

@RestController
@RequestMapping("/")
public class ProcessorController {
	
	@Autowired 
	private ProcessorService processorService;
	
	@RequestMapping("/getUser")
	public void convertUpperCase() {
		List<Takara> list=new ArrayList<>();
		User user=new User();
		list=processorService.getUser();
		System.out.println(list);
		for(int i=0;i<list.size();i++) {
			user.setUserName(list.get(i).getUserName().toUpperCase());
			user.setLastName(list.get(i).getLastName().toUpperCase());
			processorService.save(user);
		}
		
				
	}

}

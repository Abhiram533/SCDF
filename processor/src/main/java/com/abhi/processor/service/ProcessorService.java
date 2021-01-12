package com.abhi.processor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.processor.DAO.ProcessorRepo;
import com.abhi.processor.DAO.Takara_Final;
import com.abhi.processor.mode.Takara;
import com.abhi.processor.mode.User;
@Service
public class ProcessorService {
	
	@Autowired
	private ProcessorRepo processorRepo;
	
	@Autowired
	private Takara_Final takara_Final;
	
	public List<Takara> getUser(){
		return takara_Final.findAll();
	}


	public void save(User user) {
		processorRepo.save(user);
		
	}

}

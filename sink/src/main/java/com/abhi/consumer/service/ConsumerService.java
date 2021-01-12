package com.abhi.consumer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.consumer.DAO.ConsumerRepo;
import com.abhi.consumer.DAO.Final_Repo;
import com.abhi.consumer.model.TakaraDB;
import com.abhi.consumer.model.Takara_Final;
@Service
public class ConsumerService {

	@Autowired
	private ConsumerRepo consumerRepo;
	@Autowired
	private Final_Repo final_Repo;
	private TakaraDB db=new TakaraDB();
	
	public String save() {
		List<Takara_Final> list=new ArrayList<>();
		list=consumerRepo.findAll();
		System.out.println(list.toString());
		for(int i=0;i<list.size();i++) {
			db.setUserName(list.get(i).getUserName());
			db.setLastName(list.get(i).getLastName());
			final_Repo.save(db);
		}
		return "Succesfully saved";
	}
}

package com.abhi.producer.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abhi.producer.Dao.ProducerRepo;
import com.abhi.producer.model.User;
@Service
public class ProducerService {
	@Autowired
	private ProducerRepo producerRepo;
	

	public User saveToStage(MultipartFile file) throws IOException {
		StringBuilder result=new StringBuilder();
		InputStream inputStream=file.getInputStream();
		User user=new User();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                String colums[];
                colums=line.split("\t");
                user.setUserId(Long.parseLong(colums[0]));
                user.setUserName(colums[1]);
                user.setLastName(colums[2]);
                producerRepo.save(user);
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
		return user;
	}

}

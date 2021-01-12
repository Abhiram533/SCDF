package com.abhi.processor.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abhi.processor.mode.User;

@Repository
public interface ProcessorRepo  extends JpaRepository<User, Long>{
	
}

package com.abhi.producer.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.producer.model.User;
@Repository
public interface ProducerRepo extends JpaRepository<User, Long>{

}

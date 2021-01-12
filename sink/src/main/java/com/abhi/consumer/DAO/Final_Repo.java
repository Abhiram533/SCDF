package com.abhi.consumer.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.consumer.model.TakaraDB;
@Repository
public interface Final_Repo extends JpaRepository<TakaraDB,Long> {

}

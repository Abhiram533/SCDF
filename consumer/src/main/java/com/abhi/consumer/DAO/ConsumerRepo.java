package com.abhi.consumer.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.consumer.model.Takara_Final;
@Repository
public interface ConsumerRepo extends JpaRepository<Takara_Final, Long>{

}

package com.sample.repository;

import com.sample.entity.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
 
}
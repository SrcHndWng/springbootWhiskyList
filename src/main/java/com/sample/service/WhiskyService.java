package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.entity.Whisky;
import com.sample.repository.WhiskyRepository;

import java.util.List;

@Service
@Transactional
public class WhiskyService {
    @Autowired
    WhiskyRepository whiskyRepository;
    
    public List<Whisky> findAll() {
        return whiskyRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
    }
    
    public Whisky save(Whisky whisky) {
        return whiskyRepository.save(whisky);
    }
    
    public void delete(Long id) {
        whiskyRepository.delete(id);
    }
    
    public Whisky find(Long id) {
        return whiskyRepository.findOne(id);
    }
}

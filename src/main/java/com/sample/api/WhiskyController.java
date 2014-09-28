package com.sample.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sample.entity.Whisky;
import com.sample.service.WhiskyService;

import java.util.List;

@RestController
@RequestMapping("api/whiskies")
public class WhiskyController {
    @Autowired
    WhiskyService whiskyService;
    
    @RequestMapping(method = RequestMethod.GET)
    List<Whisky> getWhiskies() {
        return whiskyService.findAll();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Whisky insertWhisky(@Validated @RequestBody Whisky whisky) {
        return whiskyService.save(whisky);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    Whisky updateWhisky(@PathVariable("id") Long id, @Validated @RequestBody Whisky whisky) {
        whisky.setId(id);
        return whiskyService.save(whisky);
    }
     
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void deleteWhisky(@PathVariable("id") Long id) {
        whiskyService.delete(id);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Whisky getWhisky(@PathVariable("id") Long id) {
        return whiskyService.find(id);
    }
}

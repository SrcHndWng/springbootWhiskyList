package com.sample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Whisky {
    @Id
    @GeneratedValue
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 255)
    private String name;
    
    @NotNull
    @Min(0)
    private Long price;
}

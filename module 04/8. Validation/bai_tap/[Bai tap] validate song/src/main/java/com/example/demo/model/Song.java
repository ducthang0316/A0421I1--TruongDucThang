package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Component
public class Song implements Validator {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(max = 800)
    private String name;

    @NotBlank
    @Size(max = 300)
    private String singer;

    @NotBlank
    @Size(max = 1000)
    private String type;

    public Song() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Song.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Song song = (Song) target;

        String name = song.getName();
        String singer = song.getSinger();
        String type = song.getType();

        if (!name.matches("^[A-Za-z0-9 ]+$")){
            errors.rejectValue("name", "name.matches");
        }

        if (!singer.matches("^[A-Za-z0-9 ]+$")){
            errors.rejectValue("singer", "singer.matches");
        }

        if (!type.matches("^[A-Za-z0-9, ]+$")){
            errors.rejectValue("type", "type.matches");
        }
    }
}

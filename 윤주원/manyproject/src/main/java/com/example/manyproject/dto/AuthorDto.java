package com.example.manyproject.dto;

public class AuthorDto {

    private Long id;
    private String name;
    // constructors, getters and setters, toString


    public AuthorDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}

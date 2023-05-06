package com.example.manyproject.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookDto {

        private Long id;
        private String title;
        private List<Long> authorIds;

        // getters and setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorIds(List<Long> authorIds) {
        this.authorIds = authorIds;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Long> getAuthorIds() {
        return authorIds;
    }
}

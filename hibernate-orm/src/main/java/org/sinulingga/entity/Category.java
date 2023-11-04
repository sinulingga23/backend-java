package org.sinulingga.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(length = 36)
    private String id;
    @Column(name = "name", unique = true, nullable = false, length = 100)
    private String name;
    @Column(name = "description", unique = false, nullable = false)
    private String description;

    public Category() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

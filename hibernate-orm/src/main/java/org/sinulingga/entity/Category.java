package org.sinulingga.entity;

import jakarta.persistence.*;
import org.sinulingga.definition.Status;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(length = 36)
    private String id;

    @Column(name = "name", nullable = false, length = 100, unique = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    @Column(name = "code", nullable = true, length = 20)
    private String code;

    @Column(name = "description", unique = false, nullable = false)
    private String description;

    public Category() {

    }


    public Category(String id, String name, String code, String description) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
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

    public Set<Product> getProducts() {
        return products;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", products=" + products +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

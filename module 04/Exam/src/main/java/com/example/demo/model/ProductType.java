package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;

    @OneToMany(mappedBy = "productType",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    public ProductType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}

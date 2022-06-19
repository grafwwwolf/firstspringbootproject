package ru.pigarev.springbootproj.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "buyers")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    public Buyer() {
    }

    @ManyToMany
    @JoinTable(
            name = "buyers_products",
            joinColumns = @JoinColumn(name = "buyers_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id")
    )
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
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

    @Override
    public String toString() {
        return "Buyer:" +
                "id=" + id +
                ", name: '" + name + "'";
    }
}

package com.ptm.projectintellijexample.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Products")
@Getter
@Setter
@NoArgsConstructor

public class Product implements Serializable {
    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private Double price;
    private Double priceOld;
    private String image;
    private Integer quantity;
    private Integer categoryId;
    private Boolean status;
    private String description;
    private Date createDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId", referencedColumnName = "id", insertable = false, updatable = false)
    private Category category;

}


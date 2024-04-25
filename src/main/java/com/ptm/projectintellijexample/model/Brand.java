package com.ptm.projectintellijexample.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "brands")
@NoArgsConstructor
@AllArgsConstructor


public class Brand implements Serializable {
    @Id
    @Column(name = "brand_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brandId;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "logo")
    private String logo;

}

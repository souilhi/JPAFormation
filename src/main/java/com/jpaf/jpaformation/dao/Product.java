package com.jpaf.jpaformation.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;

    private String product;

    private String designation;

    public Product() {
    }

    public Product(String product, String designation) {
        this.product = product;
        this.designation = designation;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public boolean equals(Object obj) {
        boolean resultat = false;

        if (obj == this) {
            resultat = true;
        } else {
            if (!(obj instanceof Product)) {
                resultat = false;
            } else {
                Product autre = (Product) obj;
                if (!product.equals(autre.product)) {
                    resultat = false;
                } else {
                    if (designation != autre.designation) {
                        resultat = false;
                    } else {
                        resultat = true;
                    }
                }
            }
        }
        return resultat;
    }

    public int hashCode() {
        return (product + designation).hashCode();
    }
}

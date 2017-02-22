package com.company.totalfield.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import java.math.BigDecimal;

@NamePattern("%s|name")
@Table(name = "TOTALFIELD_PRODUCT")
@Entity(name = "totalfield$Product")
public class Product extends StandardEntity {
    private static final long serialVersionUID = -1913956804816351012L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Column(name = "PRICE", nullable = false)
    protected BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
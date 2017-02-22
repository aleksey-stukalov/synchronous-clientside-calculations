package com.company.totalfield.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import java.math.BigDecimal;

@NamePattern("%s|name")
@Table(name = "TOTALFIELD_SERVICE")
@Entity(name = "totalfield$Service")
public class Service extends StandardEntity {
    private static final long serialVersionUID = 2034122543806638049L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Column(name = "HOURLY_PRICE", nullable = false)
    protected BigDecimal hourlyPrice;

    @Column(name = "STANDARD_ESTIMATION")
    protected BigDecimal standardEstimation;

    public BigDecimal getStandardEstimation() {
        return standardEstimation;
    }

    public void setStandardEstimation(BigDecimal standardEstimation) {
        this.standardEstimation = standardEstimation;
    }



    public BigDecimal getHourlyPrice() {
        return hourlyPrice;
    }

    public void setHourlyPrice(BigDecimal hourlyPrice) {
        this.hourlyPrice = hourlyPrice;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
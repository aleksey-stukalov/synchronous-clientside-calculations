package com.company.totalfield.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s (%s hours)|service,hours")
@Table(name = "TOTALFIELD_ORDER_SERVICE_ITEM")
@Entity(name = "totalfield$OrderServiceItem")
public class OrderServiceItem extends StandardEntity {
    private static final long serialVersionUID = 9104760035283124003L;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SERVICE_ID")
    protected Service service;

    @Column(name = "HOURS", nullable = false)
    protected BigDecimal hours;

    @Column(name = "AMOUNT")
    protected BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    protected Order order;

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }


    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }


    public void setService(Service service) {
        this.service = service;
    }

    public Service getService() {
        return service;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }


}
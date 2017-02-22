package com.company.totalfield.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Column;
import com.haulmont.chile.core.annotations.NamePattern;
import java.math.BigDecimal;

@NamePattern("%s x %s|product,quantity")
@Table(name = "TOTALFIELD_ORDER_PRODUCT_ITEM")
@Entity(name = "totalfield$OrderProductItem")
public class OrderProductItem extends StandardEntity {
    private static final long serialVersionUID = -5583463232254787381L;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT_ID")
    protected Product product;

    @Column(name = "QUANTITY", nullable = false)
    protected Integer quantity;

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


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }


    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }


}
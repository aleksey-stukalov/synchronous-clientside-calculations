package com.company.totalfield.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "TOTALFIELD_ORDER")
@Entity(name = "totalfield$Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = -1235796741013171520L;

    @Column(name = "NUMBER_", nullable = false)
    protected String number;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "order")
    protected Set<OrderProductItem> products;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "order")
    protected Set<OrderServiceItem> services;

    @Column(name = "TOTAL_AMOUNT")
    protected BigDecimal totalAmount;

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setProducts(Set<OrderProductItem> products) {
        this.products = products;
    }

    public Set<OrderProductItem> getProducts() {
        return products;
    }

    public void setServices(Set<OrderServiceItem> services) {
        this.services = services;
    }

    public Set<OrderServiceItem> getServices() {
        return services;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }


}
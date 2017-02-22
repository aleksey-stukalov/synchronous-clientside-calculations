package com.company.totalfield.web.order;

import com.company.totalfield.entity.Order;
import com.company.totalfield.entity.OrderProductItem;
import com.company.totalfield.entity.OrderServiceItem;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

public class OrderEdit extends AbstractEditor<Order> {

    @Inject
    private CollectionDatasource<OrderProductItem, UUID> productsDs;

    @Inject
    private CollectionDatasource<OrderServiceItem, UUID> servicesDs;

    @Override
    public void init(Map<String, Object> params) {
    }

    @Override
    public void ready() {
        productsDs.addCollectionChangeListener(e -> getItem().setTotalAmount(calculateTotalAmount()));
        servicesDs.addCollectionChangeListener(e -> getItem().setTotalAmount(calculateTotalAmount()));
    }

    private BigDecimal calculateTotalAmount() {

        BigDecimal totalServices = BigDecimal.ZERO;
        BigDecimal totalProducts = BigDecimal.ZERO;

        if (getItem().getServices() != null)
            totalServices =
                    getItem().getServices().stream()
                            .map(OrderServiceItem::getAmount)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (getItem().getProducts() != null)
            totalProducts =
                getItem().getProducts().stream()
                        .map(OrderProductItem::getAmount)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalServices.add(totalProducts);
    }
}
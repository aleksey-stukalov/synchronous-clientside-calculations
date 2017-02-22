package com.company.totalfield.web.orderproductitem;

import com.company.totalfield.entity.OrderProductItem;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.components.TextField;

import javax.inject.Named;
import java.math.BigDecimal;
import java.util.Map;

public class OrderProductItemEdit extends AbstractEditor<OrderProductItem> {
    @Named("fieldGroup.quantity")
    private TextField quantityField;

    @Named("fieldGroup.product")
    private LookupPickerField productField;

    @Override
    public void init(Map<String, Object> params) {
        quantityField.addValueChangeListener(this::calculateAmount);
        productField.addValueChangeListener(this::calculateAmount);
    }

    private void calculateAmount(ValueChangeEvent valueChangeEvent) {
        if (getItem() != null && getItem().getProduct() != null && getItem().getQuantity() != null) {
            getItem().setAmount(getItem().getProduct().getPrice()
                    .multiply(new BigDecimal(getItem().getQuantity())));
        } else
            getItem().setAmount(null);
    }
}
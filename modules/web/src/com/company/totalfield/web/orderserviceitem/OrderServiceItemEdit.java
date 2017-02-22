package com.company.totalfield.web.orderserviceitem;

import com.company.totalfield.entity.OrderServiceItem;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.components.TextField;

import javax.inject.Named;
import java.util.Map;

public class OrderServiceItemEdit extends AbstractEditor<OrderServiceItem> {

    @Named("fieldGroup.hours")
    private TextField hoursField;

    @Named("fieldGroup.service")
    private LookupPickerField serviceField;

    @Override
    public void init(Map<String, Object> params) {
        serviceField.addValueChangeListener(e -> {
            if (getItem().getService() != null)
                getItem().setHours(getItem().getService().getStandardEstimation());
            else
                getItem().setHours(null);
            calculateAmount(e);
        });

        hoursField.addValueChangeListener(this::calculateAmount);
    }

    private void calculateAmount(ValueChangeEvent valueChangeEvent) {
        if (getItem() != null && getItem().getService() != null && getItem().getHours() != null) {
            getItem().setAmount(getItem().getService().getHourlyPrice()
                    .multiply(getItem().getHours()));
        } else
            getItem().setAmount(null);
    }
}
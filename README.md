# synchronous-clientside-calculations

The sample shows how to calculate fields like "total amount", depending on the changes of the other fields, including sub-collections like items in an order.

Created in response to the ["total amount" qestion](https://www.cuba-platform.com/support/topic/total-amount) on the CUBA support forum. 

## Short Project Overview

The [Order](https://github.com/aleksey-stukalov/synchronous-clientside-calculations/blob/master/modules/global/src/com/company/totalfield/entity/Order.java) entity contains two sets of order items:
- [Order items with products](https://github.com/aleksey-stukalov/synchronous-clientside-calculations/blob/master/modules/global/src/com/company/totalfield/entity/OrderProductItem.java), specifying a product and quantity of the product in the order 
- [Order items with services](https://github.com/aleksey-stukalov/synchronous-clientside-calculations/blob/master/modules/global/src/com/company/totalfield/entity/OrderServiceItem.java), specifying a service and a number of hours to be provided in the order
 
The total price field of an order is calculated in the [OrderEdit](https://github.com/aleksey-stukalov/synchronous-clientside-calculations/tree/master/modules/web/src/com/company/totalfield/web/order) controller of the [order-edit](https://github.com/aleksey-stukalov/synchronous-clientside-calculations/blob/master/modules/web/src/com/company/totalfield/web/order/order-edit.xml) screen as sum of amount values of all order items, products and services.

Amounts of each line of the order items are calculated in the [OrderProductItemEdit](https://github.com/aleksey-stukalov/synchronous-clientside-calculations/blob/master/modules/web/src/com/company/totalfield/web/orderproductitem/OrderProductItemEdit.java) and [OrderServiceItemEdit](https://github.com/aleksey-stukalov/synchronous-clientside-calculations/blob/master/modules/web/src/com/company/totalfield/web/orderserviceitem/OrderServiceItemEdit.java) controllers of the [product-item-edit](https://github.com/aleksey-stukalov/synchronous-clientside-calculations/blob/master/modules/web/src/com/company/totalfield/web/orderproductitem/order-product-item-edit.xml) and [service-item-edit](https://github.com/aleksey-stukalov/synchronous-clientside-calculations/blob/master/modules/web/src/com/company/totalfield/web/orderserviceitem/order-service-item-edit.xml) screens accordingly, using the following logic:
- For product order items: the product price (defined in the [Product](https://github.com/aleksey-stukalov/synchronous-clientside-calculations/blob/master/modules/global/src/com/company/totalfield/entity/Product.java) entity) is multiplied by the quantity field (defined in the [OrderProductItem](https://github.com/aleksey-stukalov/synchronous-clientside-calculations/blob/master/modules/global/src/com/company/totalfield/entity/OrderProductItem.java))
- For service order items: the service hourly price (defined in the [Service](https://github.com/aleksey-stukalov/synchronous-clientside-calculations/blob/master/modules/global/src/com/company/totalfield/entity/Service.java) entity) is multiplied by the hours field (defined in the [OrderServiceItem](https://github.com/aleksey-stukalov/synchronous-clientside-calculations/blob/master/modules/global/src/com/company/totalfield/entity/OrderServiceItem.java))

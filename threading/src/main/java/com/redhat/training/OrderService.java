
package com.redhat.training;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OrderService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);

    public Order csvToObject(String csv) {
        String[] columns = csv.split(";");
        
        Order order = new Order();
        order.setOrderId(Long.parseLong(columns[0]));
        order.setProductName(columns[1]);
        order.setPrice(new BigDecimal(columns[2]));
        order.setTax(new BigDecimal(columns[3]));
        return order;
    }

    public void updateDatabase(Order order) throws Exception {
        Thread.sleep(100);
        LOG.info("Order " + order.getOrderId() + " updated");
    }

}

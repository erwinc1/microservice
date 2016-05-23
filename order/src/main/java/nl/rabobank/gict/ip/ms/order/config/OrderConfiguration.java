package nl.rabobank.gict.ip.ms.order.config;

import com.yammer.dropwizard.config.Configuration;

import javax.validation.Valid;

public class OrderConfiguration extends Configuration {


    @Valid
    private OrderNumberConfiguration ordernumber;

    public OrderNumberConfiguration getOrder() {
        return ordernumber;
    }

    public void setOrdernumber(OrderNumberConfiguration ordernumber) {
        this.ordernumber = ordernumber;
    }
}

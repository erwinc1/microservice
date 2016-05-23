package nl.rabobank.gict.ip.ms.order.start;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import nl.rabobank.gict.ip.ms.order.config.OrderConfiguration;
import nl.rabobank.gict.ip.ms.order.healthcheck.OrderHealthCheck;
import nl.rabobank.gict.ip.ms.order.resource.OrderResource;

public class OrderStart extends Application<OrderConfiguration> {

    public static void main(String[] args) throws Exception {
        new OrderStart().run(args);
    }

    public OrderStart() {

    }

    @Override
    public void run(final OrderConfiguration orderConfiguration, final Environment environment) throws Exception {
        environment.jersey().register(new OrderResource());
        environment.lifecycle().manage(new OrderClientManager(orderConfiguration));
        environment.healthChecks().register("orderHc", new OrderHealthCheck());
    }

}

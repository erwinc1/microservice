package nl.rabobank.gict.ip.ms.order.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.lifecycle.Managed;
import nl.rabobank.gict.ip.ms.order.config.OrderConfiguration;

public class OrderClientManager implements Managed {
    private static final Logger LOG = LoggerFactory.getLogger(OrderClientManager.class);

    private final OrderClient orderClient;

    public OrderClientManager(final OrderConfiguration orderConfiguration) {
        orderClient = new OrderClient(orderConfiguration);
    }

    @Override
    public void start() throws Exception {
        LOG.info("Starting service.");
        final Thread consulThread = new Thread(orderClient,"consul thread");
        consulThread.start();
    }

    @Override
    public void stop() throws Exception {
        orderClient.stop();
    }
}

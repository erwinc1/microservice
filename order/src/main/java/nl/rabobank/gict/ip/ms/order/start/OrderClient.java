package nl.rabobank.gict.ip.ms.order.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.net.HostAndPort;
import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.NotRegisteredException;

import nl.rabobank.gict.ip.ms.order.config.OrderConfiguration;

public class OrderClient implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(OrderClient.class);
    private final OrderConfiguration orderConfiguration;

    public OrderClient(final OrderConfiguration orderConfiguration) {
        this.orderConfiguration = orderConfiguration;
    }

    /** Service information */
    private boolean running = true;

    private AgentClient agentClient;

    public void stop() {
        LOG.info("Stopping service.");
        running = false;
        if (agentClient.isRegistered(orderConfiguration.getServiceName())) {
            agentClient.deregister(orderConfiguration.getServiceName());
        }
    }

    @Override
    public void run() {
        final Consul consul =
                Consul.builder().withHostAndPort(HostAndPort.fromParts(orderConfiguration.getServiceAddress(), 8500))
                    .build();
        agentClient = consul.agentClient();
        while (running) {
            try {
                agentClient.register(orderConfiguration.getServicePort(), 5L, orderConfiguration.getServiceName(),
                    orderConfiguration.getServiceId());
                agentClient.pass(orderConfiguration.getServiceId());
                Thread.sleep(4000);
            } catch (final InterruptedException | NotRegisteredException e) {
                e.printStackTrace();
            }
        }
    }
}

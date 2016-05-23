package nl.rabobank.gict.ip.ms.order.start;

import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.NotRegisteredException;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

import nl.rabobank.gict.ip.ms.order.config.OrderConfiguration;
import nl.rabobank.gict.ip.ms.order.resource.OrderResource;

public class OrderService extends Service<OrderConfiguration> {

    public static void main(String[] args) throws Exception {
        new OrderService().run(args);
        enlist();
    }

    private static void enlist() throws NotRegisteredException {
        final Consul consul = Consul.builder().build();
        final AgentClient agentClient = consul.agentClient();

        final String serviceName = "orders";
        final String serviceId = "1";

        agentClient.register(9009, 3L, serviceName, serviceId);
        agentClient.pass(serviceId); // check in with Consul, serviceId required only.  client will prepend "service:" for service level checks.
    }

    @Override
    public void initialize(Bootstrap<OrderConfiguration> bootstrap) {
        bootstrap.setName("orders");
    }

    @Override
    public void run(final OrderConfiguration orderConfiguration, final Environment environment) throws Exception {
        environment.addResource(new OrderResource(orderConfiguration.getOrder()));
    }
}

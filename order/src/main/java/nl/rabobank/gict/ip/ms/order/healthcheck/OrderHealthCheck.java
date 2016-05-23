package nl.rabobank.gict.ip.ms.order.healthcheck;

import com.codahale.metrics.health.HealthCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderHealthCheck extends HealthCheck {
    private static final Logger LOG = LoggerFactory.getLogger(OrderHealthCheck.class);

    @Override
    protected Result check() throws Exception {
        LOG.info("OrderHealthCheck - OK!");
        return Result.healthy();
    }
}

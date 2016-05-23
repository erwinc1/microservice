package nl.rabobank.gict.ip.ms.order.config;

import org.hibernate.validator.constraints.NotEmpty;

import io.dropwizard.Configuration;

public class OrderConfiguration extends Configuration {
    @NotEmpty
    private String serviceName;
    private String serviceId;
    private String serviceAddress;
    private int servicePort;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(final String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(final String serviceId) {
        this.serviceId = serviceId;
    }

    public int getServicePort() {
        return servicePort;
    }

    public void setServicePort(final int servicePort) {
        this.servicePort = servicePort;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(final String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}

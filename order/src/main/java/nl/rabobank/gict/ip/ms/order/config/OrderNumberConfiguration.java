package nl.rabobank.gict.ip.ms.order.config;

import javax.validation.constraints.NotNull;

public class OrderNumberConfiguration {

    @NotNull
    private String id;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }
}

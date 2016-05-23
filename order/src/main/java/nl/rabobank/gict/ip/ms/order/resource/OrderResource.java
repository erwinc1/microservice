package nl.rabobank.gict.ip.ms.order.resource;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nl.rabobank.gict.ip.ms.order.config.OrderNumberConfiguration;

@Path("/orders")
public class OrderResource {
    private final OrderNumberConfiguration orderConfiguration;

    public OrderResource(OrderNumberConfiguration orderConfiguration) {
        this.orderConfiguration = orderConfiguration;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getOrders() throws IOException {
        // final String jsonResponse = FileUtils.readFileToString(new File("ordersResponse.json"));
        return "{resp}";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String createOrder() {
        return orderConfiguration.getId();
    }

    public static void main(String[] args) throws IOException {
    }

}

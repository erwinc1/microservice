package nl.rabobank.gict.ip.ms.order.resource;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/orders")
public class OrderResource {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getOrders() throws IOException {
        // final String jsonResponse = FileUtils.readFileToString(new File("ordersResponse.json"));
        return "{resp}";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String createOrder() {
        return "42";
    }

    public static void main(String[] args) throws IOException {
    }

}

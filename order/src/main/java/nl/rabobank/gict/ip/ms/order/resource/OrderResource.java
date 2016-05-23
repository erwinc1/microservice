package nl.rabobank.gict.ip.ms.order.resource;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/orders")
public class OrderResource {
    final String firstHalfResponse = "{\n" + "  \"orderNumber\": 42,\n" + "  \"shippingState\": \"shipped\",\n"
            + "  \"billingState\": \"paid\",\n" + "  \"cost\": 144.44,\n"
            + "  \"description\": \"Some lovely beverages\",\n" + "  \"orderLines\": [\n" + "    {\n"
            + "      \"name\": \"Jack Daniels\",\n" + "      \"category\": \"Tennessee whisky\",\n"
            + "      \"quantity\": \"2\",\n" + "      \"cost\": 19.95\n" + "    }\n" + "  ],\n"
            + "  \"contactInformation\": {\n" + "    \"name\": \"";
    final String secondHalfResponse = "\",\n" + "    \"phone\": \"+31 88 58 64 640\",\n"
            + "    \"email\": \"willem.dekker@luminis.eu\"\n" + "  },\n" + "  \"carrierInformation\": {\n"
            + "    \"carrier\": \"UPS\",\n" + "    \"trackingId\": \"AZX3355FD53\"\n" + "  },\n"
            + "  \"shippingAddress\": {\n" + "    \"street\": \"Lichtenauerlaan 120\",\n"
            + "    \"city\": \"Rotterdam\",\n" + "    \"postCode\": \"3062 ME\"\n" + "  },\n"
            + "  \"billingAddress\": {\n" + "    \"street\": \"Herman de Manpark 37\",\n"
            + "    \"city\": \"Lopik\",\n" + "    \"postCode\": \"3411 ZN\"\n" + "  }\n" + "}";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getOrders(@QueryParam("user") final String user) throws IOException {
        if (user != null && !user.isEmpty()) {
            return firstHalfResponse + user + secondHalfResponse;
        }
        return firstHalfResponse + secondHalfResponse;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String createOrder() {
        return "42";
    }

    public static void main(String[] args) throws IOException {
    }

}

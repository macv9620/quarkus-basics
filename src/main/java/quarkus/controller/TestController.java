package quarkus.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("/saludar")
public class TestController {

    @GET
    @Path("/dia")
    public String saludarDia(@QueryParam("day") String day) {
        return "Hola desde quarkus día " + day;
    }

    @GET
    @Path("/tarde/{day}")
    public String saludarTarde(@PathParam("day") String day) {
        return "Hola desde quarkus tarde " + day;
    }

}

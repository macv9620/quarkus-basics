package quarkus.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import quarkus.entity.Temperatura;
import quarkus.service.ITemperaturaService;

import java.util.List;

@Path("/temperatura")
public class TemperaturaController {
    private final ITemperaturaService temperaturaService;

    @Inject
    public TemperaturaController(ITemperaturaService temperaturaService) {
        this.temperaturaService = temperaturaService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTemperatura(Temperatura temperatura){
        temperaturaService.addTemperatura(temperatura);

        return Response
                .status(Response.Status.CREATED)
                .entity(temperatura)
                .header("customHeader", "customValue")
                .build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/lista")
    public List<Temperatura> getTemperaturas(){
        return temperaturaService.getTemperaturas();
    }

    @GET
    @Path("/mayor")
    public int getMayot(){
        return temperaturaService.getMayor();
    }
}

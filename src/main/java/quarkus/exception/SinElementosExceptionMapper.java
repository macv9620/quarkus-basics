package quarkus.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.NoSuchElementException;

//Anotación para que sea reconocida y gestionada por Quarkus
@Provider
//Debe implementar ExceptionMapper<NoSuchElementException> con el tipo de error a manejar
public class SinElementosExceptionMapper implements ExceptionMapper<NoSuchElementException> {
    //El record sirve para responder con un error personalizado
    public static record ExeptionResponseDTO(String message, String detail){}
    @Override
    public Response toResponse(NoSuchElementException e) {
        ExeptionResponseDTO exeptionResponseDTO = new ExeptionResponseDTO(
                "Upps",
                e.getMessage());
        //Se construye y genera la respuesta a la petición desde este componente cada vez
        //que se presente un NoSuchElementException
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(exeptionResponseDTO)
                .build();
    }
}

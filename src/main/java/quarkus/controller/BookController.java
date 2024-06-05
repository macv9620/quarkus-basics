package quarkus.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import quarkus.entity.BookEntity;
import quarkus.service.BookService;

@Path("/books")
public class BookController {
    private final BookService bookService;

    @Inject
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    public Response getAll(@QueryParam("pagesGreaterThan") Integer pagesGreaterThan){
        return Response
                .status(Response.Status.OK)
                .entity(bookService.getAll(pagesGreaterThan))
                .build();
    }

    @POST
    @Transactional
    //Agregar anotación de validación
    public Response create(@Valid BookEntity bookEntity){
        return Response
                .status(Response.Status.CREATED)
                .entity(bookService.create(bookEntity))
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id){
        return Response
                .status(Response.Status.OK)
                .entity(bookService.getById(id))
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteById(@PathParam("id") Long id){
        bookService.deleteById(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateById(@PathParam("id") Long id, BookEntity bookInfoToUpdate){

        return Response
                .status(Response.Status.OK)
                .entity(bookService.updateById(id, bookInfoToUpdate))
                .build();

    }
}

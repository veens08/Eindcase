package org.hoestschaamte.corona.resources;

import org.hoestschaamte.corona.domain.Reservering;
import org.hoestschaamte.corona.domain.Tafel;
import org.hoestschaamte.corona.services.ReserveringDaoService;
import org.hoestschaamte.corona.services.TafelDaoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path ("/reserveringen")
@Transactional(Transactional.TxType.REQUIRED)
public class ReserveringResource {

    @Inject
    private ReserveringDaoService rds;

    @Inject
    private TafelDaoService tds;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reservering> getReseveringen() {
        return rds.getAll();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addReservering(@Valid Reservering reservering) {
        reservering.setCode(Reservering.createReserveringsCode());
        Tafel toegewezenTafel = tds.wijsBeschikbareTafelToe(reservering.getTijdSlot());
        reservering.setTafel(toegewezenTafel);
        rds.save(reservering);
        System.out.println(reservering);
        return Response.
                status(Response.Status.CREATED)
                .entity(reservering)
                .build();
    }

    @GET
    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    public Reservering getReserveringByCode(@Context UriInfo uriInfo) {
        final String reserveringsCode = uriInfo.getQueryParameters().getFirst("code");
        return rds.getByReserveringsCode(reserveringsCode);
    }

    @GET
    @Path("/{id}")
    @Produces
    public Reservering getById(@PathParam("id") int id) {
        return rds.getById(id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteReserveringByID(@PathParam("id") int id){
        rds.deleteById(id);
    }

}


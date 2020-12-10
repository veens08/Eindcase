package org.hoestschaamte.corona.resources;

import org.hoestschaamte.corona.domain.Reservering;
import org.hoestschaamte.corona.services.ReserveringDaoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path ("/reserveringen")
@Transactional(Transactional.TxType.REQUIRED)
public class ReserveringResource {

    @Inject
    private ReserveringDaoService rds;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reservering> getReseveringen() {
        return rds.getAll();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addReservering(Reservering reservering) {
        if (reservering.getContacpersoon() != null) {
            rds.save(reservering);
            System.out.println(reservering);
            return Response.
                    status(Response.Status.CREATED)
                    .entity(reservering)
                    .build();
        } else {
            final String message = "Contactpersoon mag niet ontbreken";
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(message)
                    .build();
        }

    }

    @GET
    @Path("/{reserveringsCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reservering getReserveringByCode(@PathParam("reserveringsCode") String reserveringsCode) {
        return rds.getByReserveringsCode(reserveringsCode);
    }
}


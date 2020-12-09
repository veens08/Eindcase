package resources;

import domain.Reservering;
import services.ReserveringDaoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path ("/reserveringen")
@Transactional(Transactional.TxType.REQUIRED)
public class ReserveringResources {

    @Inject
    private ReserveringDaoService rds;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reservering> getReseveringen () {
        return rds.getReserveringen ();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addReservering(Reservering reservering) {
        rds.saveReservering (reservering);
    }
}


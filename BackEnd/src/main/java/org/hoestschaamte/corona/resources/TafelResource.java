package org.hoestschaamte.corona.resources;

import org.hoestschaamte.corona.domain.Reservering;
import org.hoestschaamte.corona.domain.Tafel;
import org.hoestschaamte.corona.services.ReserveringDaoService;
import org.hoestschaamte.corona.services.TafelDaoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tafels")
@Transactional(Transactional.TxType.REQUIRED)
public class TafelResource {

    @Inject
    private TafelDaoService tds;

    @Inject
    private ReserveringDaoService rds;

    @GET
    @Path ("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tafel> getTafels() {
        return tds.getAll();
    }

    @GET
    @Path("/{tijdslot}")
    @Produces(MediaType.APPLICATION_JSON)
    public int tafelsBeschikbaarPerTijdslot(@PathParam("tijdslot") int tijdslot){
        final int DEFAULT_AANTAL_TAFELS = 10;
        List<Reservering> lijstMetReserveringenInTijdslot = rds.getReserveringenByTijdslot(tijdslot);
        int aantalReserveringenInTijdslot = lijstMetReserveringenInTijdslot.size();
        int aantalBeschikbareTafels = DEFAULT_AANTAL_TAFELS - aantalReserveringenInTijdslot;

        return aantalBeschikbareTafels;
    }
}

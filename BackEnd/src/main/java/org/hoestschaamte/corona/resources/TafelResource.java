package org.hoestschaamte.corona.resources;

import org.hoestschaamte.corona.domain.Reservering;
import org.hoestschaamte.corona.domain.Tafel;
import org.hoestschaamte.corona.services.ReserveringDaoService;
import org.hoestschaamte.corona.services.TafelDaoService;

import javax.ejb.Local;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    @Path("/{datum}/{tijdslot}")
    @Produces(MediaType.APPLICATION_JSON)
    public int tafelsBeschikbaarPerTijdslot(@PathParam("datum") String datum, @PathParam("tijdslot") int tijdslot){
        final int DEFAULT_AANTAL_TAFELS = 10;

        //Parse String to LocalDate
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDate datumParsed = LocalDate.parse(datum, dtf);

        List<Reservering> lijstMetReserveringenInTijdslot = rds.getReserveringenByTijdslot(datum, tijdslot);

        int aantalReserveringenInTijdslot = lijstMetReserveringenInTijdslot.size();

        return DEFAULT_AANTAL_TAFELS - aantalReserveringenInTijdslot;
    }
}

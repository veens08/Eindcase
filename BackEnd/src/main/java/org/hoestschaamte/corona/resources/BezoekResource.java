package org.hoestschaamte.corona.resources;

import org.hoestschaamte.corona.domain.Bezoek;
import org.hoestschaamte.corona.domain.Persoon;
import org.hoestschaamte.corona.domain.Reservering;
import org.hoestschaamte.corona.services.BezoekDaoService;
import org.hoestschaamte.corona.services.ReserveringDaoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.Set;

@Path ("/bezoeken")
@Transactional(Transactional.TxType.REQUIRED)
public class BezoekResource {

    @Inject
    private BezoekDaoService bds;

    @Inject
    private ReserveringDaoService rds;

    @GET
    @Path ("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bezoek> getBezoeken() {
        return bds.getAll();
    }

    @POST
    @Path ("/add")
    @Consumes (MediaType.APPLICATION_JSON)
    public Response addBezoeken(@Valid Bezoek bezoek, Reservering reservering){
        // Geef aan dat de reservering is omgeboekt
        reservering.setOmgeboekt(true);
        rds.update(reservering);
        // En sla dan het bezoek op
        bds.save(bezoek);
        System.out.println (bezoek);
        return Response.
                status (Response.Status.CREATED).
                entity (bezoek).
                build ();
    }

    @GET
    @Path("/{id}")
    @Produces
    public Bezoek getById(@PathParam("id") int id) {
        return bds.getById(id);
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Bezoek> getBezoekenByDatumTijdSlotAndTafelCluster(@Context UriInfo uriInfo) {
        System.out.println("Ik ben aangeroepen3");
        final int tafelcluster = Integer.parseInt(uriInfo.getQueryParameters().getFirst("tafelcluster"));
        final String datum = uriInfo.getQueryParameters().getFirst("datum");
        final int tijdslot = Integer.parseInt(uriInfo.getQueryParameters().getFirst("tijdslot"));

        System.out.println(tijdslot);
        System.out.println(datum);
        System.out.println(tafelcluster);
        return bds.getBezoekenFromDatumTijdslotAndCluster(datum, tijdslot, tafelcluster);
    }
}

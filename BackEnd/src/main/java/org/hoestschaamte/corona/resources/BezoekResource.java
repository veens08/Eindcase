package org.hoestschaamte.corona.resources;

import org.hoestschaamte.corona.domain.Bezoek;
import org.hoestschaamte.corona.services.BezoekDaoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path ("/bezoeken")
@Transactional(Transactional.TxType.REQUIRED)
public class BezoekResource {

    @Inject
    private BezoekDaoService bds;

    @GET
    @Path ("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bezoek> getBezoeken() {
        return bds.getAll();
    }

    @POST
    @Path ("/add")
    @Consumes (MediaType.APPLICATION_JSON)
    public Response addBezoeken(@Valid Bezoek bezoek){
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
}

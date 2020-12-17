package org.hoestschaamte.corona.resources;

import org.hoestschaamte.corona.domain.Persoon;
import org.hoestschaamte.corona.services.PersoonDaoService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Path("/personen")
public class PersoonResource {

    @Inject
    private PersoonDaoService pds;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persoon> getPersonen() {
        return pds.getAll() ;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persoon getPersoon(@PathParam("id") int id) {
        return pds.getById(id) ;
    }

}

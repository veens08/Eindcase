package org.hoestschaamte.corona.resources;

import org.hoestschaamte.corona.domain.Tafel;
import org.hoestschaamte.corona.services.TafelDaoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tafels")
@Transactional(Transactional.TxType.REQUIRED)
public class TafelResource {

    @Inject
    private TafelDaoService tds;

    @GET
    @Path ("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tafel> getTafels() {
        return tds.getAll();
    }
}

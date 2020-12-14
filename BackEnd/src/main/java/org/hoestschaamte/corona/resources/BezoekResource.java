package org.hoestschaamte.corona.resources;

import org.hoestschaamte.corona.domain.Bezoek;
import org.hoestschaamte.corona.services.BezoekDaoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
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
}

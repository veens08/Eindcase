package org.hoestschaamte.corona.db;

import org.hoestschaamte.corona.domain.Reservering;
import org.junit.jupiter.api.Test;
import org.hoestschaamte.corona.db.VulDatabase;

import java.util.List;

public class DbStartUpTest {

    @Test
//    @Ignore
    void vulDeInitieleDatabase() {
        VulDatabase vulDatabase = new VulDatabase();
        vulDatabase.maakReserveringenVoorTestAan ();
        vulDatabase.maakBezoekenAanVoorTest ();
    }
    
}

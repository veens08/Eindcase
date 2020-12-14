package org.hoestschaamte.corona.db;

import org.junit.jupiter.api.Test;
import org.hoestschaamte.corona.db.VulDatabase;

public class DbStartUpTest {

    @Test
//    @Ignore
    void vulDeInitieleDatabase() {
        VulDatabase vulDatabase = new VulDatabase();
        vulDatabase.maakReserveringenVoorTestAan ();
        vulDatabase.maakBezoekersAanVoorTests ();
    }
}

package tests;

import org.junit.jupiter.api.Test;
import startUp.VulDatabase;

public class dbStartUpTests {

    @Test
//    @Ignore
    void vulDeInitieleDatabase() {
        VulDatabase vulDatabase = new VulDatabase();
        vulDatabase.maakReserveringenVoorTestAan ();
    }
}

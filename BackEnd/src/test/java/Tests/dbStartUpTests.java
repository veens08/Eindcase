package tests;

import dbStartUp.VulDatabaseTabellen;
import org.junit.jupiter.api.Test;

public class dbStartUpTests {

    @Test
//    @Ignore
    void vulDeInitieleDatabase() {
        VulDatabaseTabellen vulDatabaseTabellen = new VulDatabaseTabellen ();
        vulDatabaseTabellen.maakReserveringenVoorTestAan ();
    }
}

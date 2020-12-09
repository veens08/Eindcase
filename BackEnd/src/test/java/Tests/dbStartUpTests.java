package Tests;

import dbStartUp.VulDatabaseTabellen;
import domain.Reservering;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class dbStartUpTests {
    @Test
//    @Ignore
    void vulDeInitieleDatabase() {
        VulDatabaseTabellen vulDatabaseTabellen = new VulDatabaseTabellen ();
        vulDatabaseTabellen.maakReserveringenVoorTestAan ();
    }
}

package test;

import org.junit.Assert;
import org.junit.Test;
import ro.uaic.feaa.psi.sgsm.model.entities.Vehicule;
import ro.uaic.feaa.psi.sgsm.model.repository.MasterRepository;

import java.util.List;

public class TestVehicule {

    static MasterRepository repo = new MasterRepository();

    @Test
    public void testVehicule() {
        List<Vehicule> vehiculeList = repo.findAllVehicles();
        if (vehiculeList.size() == 0) {
            adaugaVehicule();
            vehiculeList = repo.findAllVehicles();
        }
        Assert.assertTrue(vehiculeList.size() > 0);
    }

    public static void adaugaVehicule() {
        repo.beginTransaction();

        // Adaugare vehicul 1
        Vehicule vehicul1 = new Vehicule("Mazda", "Diesel, 2.0, 150CP, 4x4, 5 locuri", 15000.0);
        repo.saveVehicle(vehicul1);

        // Adaugare vehicul 2
        Vehicule vehicul2 = new Vehicule("Audi", "Diesel, 2.0, 150CP, 4x4, 5 locuri", 20000.0);
        repo.saveVehicle(vehicul2);

        // Adaugare vehicul 3
        Vehicule vehicul3 = new Vehicule("BMW", "Diesel, 3.0, 200CP, 4x4, 5 locuri", 25000.0);
        repo.saveVehicle(vehicul3);

        repo.commitTransaction();
    }

}

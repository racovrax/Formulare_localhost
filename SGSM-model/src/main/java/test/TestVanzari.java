package test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ro.uaic.feaa.psi.sgsm.model.entities.Vanzari;
import ro.uaic.feaa.psi.sgsm.model.entities.Angajati;
import ro.uaic.feaa.psi.sgsm.model.entities.Contracte;
import ro.uaic.feaa.psi.sgsm.model.repository.MasterRepository;
import ro.uaic.feaa.psi.sgsm.model.repository.DocumentRepository;

public class TestVanzari {

    static MasterRepository repo = new MasterRepository();
    static DocumentRepository docRepo = new DocumentRepository();

    @Test
    public void testVanzari() {
        List<Vanzari> x = repo.findAllVanzari();
        if (x.size() == 0) {
            adaugaVanzari();
            x = repo.findAllVanzari();
        }
        assert x.size() > 0;
    }

    public static void adaugaVanzari() {
        Angajati angajat = new Angajati(1, "Popescu", "Ion", null);
        repo.beginTransaction();
        angajat = repo.saveAngajati(angajat);
        repo.commitTransaction();

        Contracte contract = new Contracte("2023-01-01", "Detalii vehicul", 1, "Termeni si conditii");
        docRepo.beginTransaction();
        docRepo.saveContract(contract);
        docRepo.commitTransaction();

        Vanzari v = null;
        repo.beginTransaction();
        for (int i = 1; i <= 3; i++) {
            v = new Vanzari(i, i, i, i, angajat, contract);
            repo.saveVanzari(v);
        }
        repo.commitTransaction();
    }
}

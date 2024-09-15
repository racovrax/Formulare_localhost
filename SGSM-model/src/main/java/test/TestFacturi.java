package test;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import ro.uaic.feaa.psi.sgsm.model.entities.Contracte;
import ro.uaic.feaa.psi.sgsm.model.entities.Facturi;
import ro.uaic.feaa.psi.sgsm.model.entities.Marketing;
import ro.uaic.feaa.psi.sgsm.model.entities.Plati;
import ro.uaic.feaa.psi.sgsm.model.repository.DocumentRepository;

public class TestFacturi {

    static DocumentRepository docRepo = new DocumentRepository();

    @Test
    public void testFacturi() {
        List<Facturi> x = docRepo.findAllFacturi();
        if (x.size() == 0) {
            adaugaFacturi();
            x = docRepo.findAllFacturi();
        }
        assert x.size() > 0;
    }

    public static void adaugaFacturi() {
        Contracte contract = new Contracte("2023-01-01", "Detalii vehicul", 1, "Termeni si conditii");
        docRepo.beginTransaction();
        docRepo.saveContract(contract);
        docRepo.commitTransaction();

        Facturi f = null;
        docRepo.beginTransaction();
        for (int i = 1; i <= 3; i++) {
            f = new Facturi();
            docRepo.saveFactura(f);
        }
        docRepo.commitTransaction();
    }
}

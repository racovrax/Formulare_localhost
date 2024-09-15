package test;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import ro.uaic.feaa.psi.sgsm.model.entities.Clienti;
import ro.uaic.feaa.psi.sgsm.model.repository.MasterRepository;

public class TestClienti {

    static MasterRepository repo = new MasterRepository();

    @Test
    public void testClienti() {
        List<Clienti> x = repo.findAllClienti();
        if (x.size() == 0) {
            adaugaClienti();
            x = repo.findAllClienti();
        }
        assert x.size() > 0;
    }

    public static void adaugaClienti() {
        Clienti c = null;
        repo.beginTransaction();
        for (int i = 1; i <= 3; i++) {
            c = new Clienti("071234560", i, "Istoric achizitii", "Nume", "Prenume", "email", null, null);
            repo.saveClienti(c);
        }
        repo.commitTransaction();
    }
}

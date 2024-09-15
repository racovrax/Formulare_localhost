package test.ro.uaic.feaa.psi.sgsm.test.forms;

import org.junit.Assert;
import ro.uaic.feaa.psi.sgsm.model.entities.Facturi;
import ro.uaic.feaa.psi.sgsm.model.entities.Vehicule;
import src.ro.uaic.feaa.psi.sgsm.forms.EntitiesFormCtrl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestEntitiesForm {

    public static void main(String[] args) {
        EntitiesFormCtrl form = new EntitiesFormCtrl();

        // 1. Ștergere vehicule existente din baza de date
        stergeToateFacturile();
        stergeToateVehiculele();

        // 2. Adăugare vehicule în baza de date
        adaugaVehicule(form);

        // Verificări inițiale: listele trebuie să aibă o sursă de date validă
        verificariInitiale(form);

        // 3. Adăugare factură
        form.facturaNoua();

        // 3.1 Verifică tipul de document creat - trebuie să fie Factură
        Assert.assertTrue("Tipul de document nou creat nu este corect.", form
                .getFormData().getEntitateCurenta() instanceof Facturi);

        Facturi factura = (Facturi) form.getFormData().getEntitateCurenta();

        // 3.2 Simulează setarea detaliilor facturii
        factura.setClient("Client Test");
        factura.setInvoiceNumber("INV-001");
        factura.setInvoiceDate("2024-05-21");
        Vehicule vehicle = form.getFormData().getListaVehicule().get(0); // Ensure this vehicle is not null and has a valid ID
        Assert.assertNotNull("Vehiculul nu ar trebui să fie null", vehicle);
        Assert.assertNotNull("ID-ul vehiculului nu ar trebui să fie null", vehicle.getId());
        factura.setVehicle(vehicle);
        factura.setVehiclePrice(10000.0);
        factura.setVat(19.0);
        factura.setTotalInvoice(10000.0 + 10000.0 * 0.19);

        // 4. Salvare entitate în baza de date
        form.salveazaEntitate();

        // 5. Verifică datele salvate în baza de date
        Facturi savedFactura = form.getFormData().getDocRepo().findFacturaById(factura.getId());
        Assert.assertNotNull("Factura nu a fost salvată corect în baza de date.", savedFactura);
        Assert.assertEquals("Clientul nu este corect.", "Client Test", savedFactura.getClient());
        Assert.assertEquals("Numărul facturii nu este corect.", "INV-001", savedFactura.getInvoiceNumber());
        Assert.assertEquals("Data facturii nu este corectă.", "2024-05-21", savedFactura.getInvoiceDate());
        Assert.assertEquals("Prețul vehiculului nu este corect.", 10000.0, savedFactura.getVehiclePrice(), 0.01);
        Assert.assertEquals("TVA-ul nu este corect.", 19.0, savedFactura.getVat(), 0.01);
        Assert.assertEquals("Totalul facturii nu este corect.", 10000.0 + 10000.0 * 0.19, savedFactura.getTotalInvoice(), 0.01);

        // TODO - temă + comentarii asupra acestei verificări:
        // 1) Cum identificăm în mod unic documentul pe care tocmai l-am introdus (ce verificări/validări ar mai trebui efectuate înainte de a-l salva; unde putem introduce aceste validări)?
        // 2) Ce modificări trebuie efectuate în aplicație pentru a putea extrage acest document din baza de date dacă nu știm id-ul?
    }

    private static void verificariInitiale(EntitiesFormCtrl form) {
        Assert.assertFalse(
                "BUG sau Nu există Vehicule pentru test. Rulați mai întâi testul TestVehicule din proiectul SGSM-Model",
                form.getFormData().getListaVehicule().isEmpty());

        List<Vehicule> vehiculeList = form.getFormData().getListaVehicule();
        for (Vehicule vehicul : vehiculeList) {
            Assert.assertNotNull("ID-ul vehiculului nu ar trebui să fie null", vehicul.getId());
        }
    }

    private static void stergeToateFacturile() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGSMPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        // Șterge înregistrările din tabelul facturi
        em.createQuery("DELETE FROM Facturi").executeUpdate();
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    private static void stergeToateVehiculele() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGSMPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        // Șterge înregistrările din tabelul vehicule
        em.createQuery("DELETE FROM Vehicule").executeUpdate();
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    private static void adaugaVehicule(EntitiesFormCtrl form) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGSMPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Vehicule vehicul1 = new Vehicule("Seat Leon", "Diesel, 2.0, 150CP, 4x4, 5 locuri", 10000.0);
        Vehicule vehicul2 = new Vehicule("Cupra Ateca", "Benzina, 1.6, 120CP, 4x2, 5 locuri", 20000.0);
        Vehicule vehicul3 = new Vehicule("Seat Ibiza", "Diesel, 3.0, 200CP, 4x4, 5 locuri", 30000.0);

        em.persist(vehicul1);
        em.persist(vehicul2);
        em.persist(vehicul3);

        em.getTransaction().commit();

        em.refresh(vehicul1);
        em.refresh(vehicul2);
        em.refresh(vehicul3);

        em.close();
        emf.close();

        form.getFormData().setListaVehicule(form.getFormData().getMasterRepo().findAllVehicles());
    }
}

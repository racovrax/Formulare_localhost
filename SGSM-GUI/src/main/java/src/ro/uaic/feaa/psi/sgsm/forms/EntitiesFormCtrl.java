package src.ro.uaic.feaa.psi.sgsm.forms;

import ro.uaic.feaa.psi.sgsm.model.entities.*;
import java.util.Date;

public class EntitiesFormCtrl {

    // Datele formularului sunt pastrate intr-un obiect EntitiesFormData
    private EntitiesFormData formData = new EntitiesFormData();

    public EntitiesFormData getFormData() {
        return formData;
    }

    public void setFormData(EntitiesFormData formData) {
        this.formData = formData;
    }

    // Creare angajat nou
    public void angajatNou() {
        Angajati angajat = new Angajati();
        this.formData.setEntitateCurenta(angajat);
        angajat.setNume("Nume necunoscut");
        angajat.setPrenume("Prenume necunoscut");
    }

    // Creare client nou
    public void clientNou() {
        Clienti client = new Clienti();
        this.formData.setEntitateCurenta(client);
        client.setNume("Nume necunoscut");
        client.setIstoricAchizitii("Necunoscut");
    }

    // Creare contract nou
    public void contractNou() {
        Contracte contract = new Contracte();
        this.formData.setEntitateCurenta(contract);
        contract.setDateClient("Date client necunoscute");
        contract.setDetaliiVehicul("Detalii vehicul necunoscute");
        contract.setTermeniSiConditii("Termeni si conditii necunoscute");
        contract.setDataOperare(new Date());
    }

    // Creare factura noua
    public void facturaNoua() {
        Facturi factura = new Facturi();
        this.formData.setEntitateCurenta(factura);
        factura.setClient("Client necunoscut");
        factura.setInvoiceNumber("Numar factura necunoscut");
        factura.setInvoiceDate(String.valueOf(new Date()));
        factura.setVehiclePrice(0.0);
        factura.setVat(0.0);
        factura.setTotalInvoice(0.0);
    }

    // Creare plata noua
    public void plataNoua() {
        Plati plata = new Plati();
        this.formData.setEntitateCurenta(plata);
        plata.setSume(0.0);
        plata.setDataTranzactie(String.valueOf(new Date()));
    }

    // Creare vehicul nou
    public void vehiculNou() {
        Vehicule vehicul = new Vehicule();
        this.formData.setEntitateCurenta(vehicul);
        vehicul.setNume("Nume necunoscut");
        vehicul.setDetalii("Detalii necunoscute");
        vehicul.setPreturi(0.0);
        vehicul.setId(0L);
    }

    // Creare campanie de marketing noua
    public void marketingNou() {
        Marketing marketing = new Marketing();
        this.formData.setEntitateCurenta(marketing);
        marketing.setStrategii("Campanie necunoscuta");
        marketing.setMaterialePromotionale("Tip necunoscut");
    }

    // Salvare entitate in baza de date
    public void salveazaEntitate() {
        Object entitateCurenta = this.getFormData().getEntitateCurenta();

        this.getFormData().getDocRepo().beginTransaction();
        if (entitateCurenta instanceof Facturi) {
            Facturi factura = (Facturi) entitateCurenta;
            if (factura.getVehicle() != null && factura.getVehicle().getId() != null) {
                factura.setVehicle(this.getFormData().getDocRepo().findVehiculById(factura.getVehicle().getId()));
            }
            this.getFormData().getDocRepo().saveFactura(factura);
        }
        this.getFormData().getDocRepo().commitTransaction();
    }}

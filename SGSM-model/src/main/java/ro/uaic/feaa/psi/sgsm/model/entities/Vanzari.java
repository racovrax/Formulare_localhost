package ro.uaic.feaa.psi.sgsm.model.entities;

import ro.uaic.feaa.psi.metamodel.AbstractEntity;
import ro.uaic.feaa.psi.sgsm.model.entities.Contracte;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Entity
public class Vanzari extends AbstractEntity {
    @Column(name = "id_angajat")
    private int idAngajat;

    @Column(name = "id_factura_asociata")
    private int idFacturaAsociata;

    @Column(name = "id_vanzare")
    private int idVanzare;

    @Column(name = "rapoarte_vanzari")
    private int rapoarteVanzari;

    @ManyToOne
    private Angajati angajati;

    @ManyToOne
    private Contracte contracte;

    private String tipDocument;

    // Constructori
    public Vanzari() {}

    public Vanzari(int idAngajat, int idFacturaAsociata, int idVanzare, int rapoarteVanzari, Angajati angajati, Contracte contracte) {
        this.idAngajat = idAngajat;
        this.idFacturaAsociata = idFacturaAsociata;
        this.idVanzare = idVanzare;
        this.rapoarteVanzari = rapoarteVanzari;
        this.angajati = angajati;
        this.contracte = contracte;
    }

    // Getters și Setters
    public int getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }

    public int getIdFacturaAsociata() {
        return idFacturaAsociata;
    }

    public void setIdFacturaAsociata(int idFacturaAsociata) {
        this.idFacturaAsociata = idFacturaAsociata;
    }

    public int getIdVanzare() {
        return idVanzare;
    }

    public void setIdVanzare(int idVanzare) {
        this.idVanzare = idVanzare;
    }

    public int getRapoarteVanzari() {
        return rapoarteVanzari;
    }

    public void setRapoarteVanzari(int rapoarteVanzari) {
        this.rapoarteVanzari = rapoarteVanzari;
    }

    public Angajati getAngajati() {
        return angajati;
    }

    public void setAngajati(Angajati angajati) {
        this.angajati = angajati;
    }

    public Contracte getContracte() {
        return contracte;
    }

    public void setContracte(Contracte contracte) {
        this.contracte = contracte;
    }
    public String getTipDocument() {
        return tipDocument;
    }

    public void setTipDocument(String tipDocument) {
        this.tipDocument = tipDocument;
    }
}

package ro.uaic.feaa.psi.sgsm.model.entities;

import ro.uaic.feaa.psi.metamodel.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Plati extends AbstractEntity {
    @Column(name = "data_tranzactie")
    private String dataTranzactie;

    @Column(name = "id_plata")
    private int idPlata;

    @Column(name = "metoda_de_plata")
    private String metodaDePlata;

    @Column(name = "sume")
    private double sume;

    @OneToMany(mappedBy = "plati")
    private List<Facturi> facturi;


    private String tipDocument;

    // Constructori
    public Plati() {}

    public Plati(String dataTranzactie, int idPlata, String metodaDePlata, double sume, List<Facturi> facturi) {
        this.dataTranzactie = dataTranzactie;
        this.idPlata = idPlata;
        this.metodaDePlata = metodaDePlata;
        this.sume = sume;
        this.facturi = facturi;
    }
    public String getTipDocument() {
        return tipDocument;
    }

    public void setTipDocument(String tipDocument) {
        this.tipDocument = tipDocument;
    }

    // Getters și Setters
    public String getDataTranzactie() {
        return dataTranzactie;
    }

    public void setDataTranzactie(String dataTranzactie) {
        this.dataTranzactie = dataTranzactie;
    }

    public int getIdPlata() {
        return idPlata;
    }

    public void setIdPlata(int idPlata) {
        this.idPlata = idPlata;
    }

    public String getMetodaDePlata() {
        return metodaDePlata;
    }

    public void setMetodaDePlata(String metodaDePlata) {
        this.metodaDePlata = metodaDePlata;
    }

    public double getSume() {
        return sume;
    }

    public void setSume(double sume) {
        this.sume = sume;
    }

    public List<Facturi> getFacturi() {
        return facturi;
    }

    public void setFacturi(List<Facturi> facturi) {
        this.facturi = facturi;
    }
}

package ro.uaic.feaa.psi.sgsm.model.entities;

import ro.uaic.feaa.psi.metamodel.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Angajati extends AbstractEntity {
    @Column(name = "id_angajat", unique = true)
    private int idAngajat;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @OneToMany(mappedBy = "angajati")
    private List<Vanzari> vanzari;

    // Constructori
    public Angajati() {}

    public Angajati(int idAngajat, String nume, String prenume, List<Vanzari> vanzari) {
        this.idAngajat = idAngajat;
        this.nume = nume;
        this.prenume = prenume;
        this.vanzari = vanzari;
    }

    // Getters și Setters
    public int getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public List<Vanzari> getVanzari() {
        return vanzari;
    }

    public void setVanzari(List<Vanzari> vanzari) {
        this.vanzari = vanzari;
    }
}

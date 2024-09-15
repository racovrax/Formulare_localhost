package ro.uaic.feaa.psi.sgsm.model.entities;

import ro.uaic.feaa.psi.metamodel.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicule extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nume")
    private String nume;

    @Column(name = "detalii")
    private String detalii;

    @Column(name = "preturi")
    private double preturi;

    // Constructors
    public Vehicule() {}

    public Vehicule(String nume, String detalii, double preturi) {
        this.nume = nume;
        this.detalii = detalii;
        this.preturi = preturi;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }

    public double getPreturi() {
        return preturi;
    }

    public void setPreturi(double preturi) {
        this.preturi = preturi;
    }
}

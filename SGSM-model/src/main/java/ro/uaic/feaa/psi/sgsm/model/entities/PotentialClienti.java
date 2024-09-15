package ro.uaic.feaa.psi.sgsm.model.entities;

import ro.uaic.feaa.psi.metamodel.AbstractEntity;
import ro.uaic.feaa.psi.sgsm.model.entities.Clienti;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Entity
public class PotentialClienti extends AbstractEntity {
    @Column(name = "date_contact")
    private String dateContact;

    @Column(name = "interese")
    private String interese;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @ManyToOne
    private Clienti clienti;

    // Constructori
    public PotentialClienti() {}

    public PotentialClienti(String dateContact, String interese, String nume, String prenume, Clienti clienti) {
        this.dateContact = dateContact;
        this.interese = interese;
        this.nume = nume;
        this.prenume = prenume;
        this.clienti = clienti;
    }

    // Getters și Setters
    public String getDateContact() {
        return dateContact;
    }

    public void setDateContact(String dateContact) {
        this.dateContact = dateContact;
    }

    public String getInterese() {
        return interese;
    }

    public void setInterese(String interese) {
        this.interese = interese;
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

    public Clienti getClienti() {
        return clienti;
    }

    public void setClienti(Clienti clienti) {
        this.clienti = clienti;
    }
}

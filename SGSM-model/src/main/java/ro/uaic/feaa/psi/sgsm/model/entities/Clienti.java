package ro.uaic.feaa.psi.sgsm.model.entities;

import ro.uaic.feaa.psi.metamodel.AbstractEntity;
import ro.uaic.feaa.psi.sgsm.model.entities.Contracte;
import ro.uaic.feaa.psi.sgsm.model.entities.PotentialClienti;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Clienti extends AbstractEntity {
    @Column(name = "date_contact")
    private String dateContact;

    @Column(name = "id_client")
    private int idClient;

    @Column(name = "istoric_achizitii")
    private String istoricAchizitii;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "clienti")
    private List<Contracte> contracte;

    @OneToMany(mappedBy = "clienti")
    private List<PotentialClienti> potentialClienti;

    // Constructori
    public Clienti() {}

    public Clienti(String dateContact, int idClient, String istoricAchizitii, String nume, String prenume, String email, List<Contracte> contracte, List<PotentialClienti> potentialClienti) {
        this.dateContact = dateContact;
        this.idClient = idClient;
        this.istoricAchizitii = istoricAchizitii;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.contracte = contracte;
        this.potentialClienti = potentialClienti;
    }

    // Getters și Setters
    public String getDateContact() {
        return dateContact;
    }

    public void setDateContact(String dateContact) {
        this.dateContact = dateContact;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getIstoricAchizitii() {
        return istoricAchizitii;
    }

    public void setIstoricAchizitii(String istoricAchizitii) {
        this.istoricAchizitii = istoricAchizitii;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Contracte> getContracte() {
        return contracte;
    }

    public void setContracte(List<Contracte> contracte) {
        this.contracte = contracte;
    }

    public List<PotentialClienti> getPotentialClienti() {
        return potentialClienti;
    }

    public void setPotentialClienti(List<PotentialClienti> potentialClienti) {
        this.potentialClienti = potentialClienti;
    }
}

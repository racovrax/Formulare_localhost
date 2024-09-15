package ro.uaic.feaa.psi.sgsm.model.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import ro.uaic.feaa.psi.metamodel.AbstractEntity;

@Entity
public class Contracte extends AbstractEntity {
    @Column(name = "date_client")
    private String dateClient;

    @Column(name = "detalii_vehicul")
    private String detaliiVehicul;

    @Column(name = "id_contract")
    private int idContract;

    @Column(name = "termeni_si_conditii")
    private String termeniSiConditii;

    @Column(name = "data_operare")
    private java.util.Date dataOperare;

    @ManyToOne
    private Clienti clienti;

    @ManyToOne
    private Vehicule vehicul;

    @ManyToOne
    private Marketing marketing;

    @OneToMany(mappedBy = "contracte")
    private List<Facturi> facturi;

    // Constructori
    public Contracte() {}

    public Contracte(String dateClient, String detaliiVehicul, int idContract, String termeniSiConditii, Clienti clienti, Vehicule vehicul, List<Facturi> facturi) {
        this.dateClient = dateClient;
        this.detaliiVehicul = detaliiVehicul;
        this.idContract = idContract;
        this.termeniSiConditii = termeniSiConditii;
        this.clienti = clienti;
        this.vehicul = vehicul;
        this.facturi = facturi;
    }

    // Constructor suplimentar pentru test
    public Contracte(String dateClient, String detaliiVehicul, int idContract, String termeniSiConditii) {
        this.dateClient = dateClient;
        this.detaliiVehicul = detaliiVehicul;
        this.idContract = idContract;
        this.termeniSiConditii = termeniSiConditii;
    }

    // Getters și Setters
    public String getDateClient() {
        return dateClient;
    }

    public void setDateClient(String dateClient) {
        this.dateClient = dateClient;
    }

    public String getDetaliiVehicul() {
        return detaliiVehicul;
    }

    public void setDetaliiVehicul(String detaliiVehicul) {
        this.detaliiVehicul = detaliiVehicul;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public String getTermeniSiConditii() {
        return termeniSiConditii;
    }

    public void setTermeniSiConditii(String termeniSiConditii) {
        this.termeniSiConditii = termeniSiConditii;
    }

    public java.util.Date getDataOperare() {
        return dataOperare;
    }

    public void setDataOperare(java.util.Date dataOperare) {
        this.dataOperare = dataOperare;
    }

    public Clienti getClienti() {
        return clienti;
    }

    public void setClienti(Clienti clienti) {
        this.clienti = clienti;
    }

    public Vehicule getVehicul() {
        return vehicul;
    }

    public void setVehicul(Vehicule vehicul) {
        this.vehicul = vehicul;
    }

    public Marketing getMarketing() {
        return marketing;
    }

    public void setMarketing(Marketing marketing) {
        this.marketing = marketing;
    }

    public List<Facturi> getFacturi() {
        return facturi;
    }

    public void setFacturi(List<Facturi> facturi) {
        this.facturi = facturi;
    }
}

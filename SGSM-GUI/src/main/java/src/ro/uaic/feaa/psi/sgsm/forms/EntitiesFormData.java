package src.ro.uaic.feaa.psi.sgsm.forms;

import ro.uaic.feaa.psi.sgsm.model.entities.*;
import ro.uaic.feaa.psi.sgsm.model.repository.MasterRepository;
import ro.uaic.feaa.psi.sgsm.model.repository.DocumentRepository;

import java.util.LinkedList;
import java.util.List;

public class EntitiesFormData {

    private Object entitateCurenta;
    private List<Object> listaEntitati;

    private MasterRepository masterRepo = new MasterRepository();
    private DocumentRepository docRepo = new DocumentRepository();

    private List<Angajati> listaAngajati;
    private List<Clienti> listaClienti;
    private List<Contracte> listaContracte;
    private List<Facturi> listaFacturi;
    private List<Plati> listaPlati;
    private List<Marketing> listaMarketing;
    private List<PotentialClienti> listaPotentialClienti;
    private List<Vanzari> listaVanzari;
    private List<Vehicule> listaVehicule;

    public Object getEntitateCurenta() {
        return entitateCurenta;
    }

    public void setEntitateCurenta(Object entitateCurenta) {
        this.entitateCurenta = entitateCurenta;
    }

    public List<Object> getListaEntitati() {
        return listaEntitati;
    }

    public void setListaEntitati(List<Object> listaEntitati) {
        this.listaEntitati = listaEntitati;
    }

    public List<Angajati> getListaAngajati() {
        if (this.listaAngajati == null) {
            this.listaAngajati = this.masterRepo.findAllAngajati();
        }
        return listaAngajati;
    }

    public List<Clienti> getListaClienti() {
        if (this.listaClienti == null) {
            this.listaClienti = this.masterRepo.findAllClienti();
        }
        return listaClienti;
    }

   /* public List<Contracte> getListaContracte() {
        if (this.listaContracte == null) {
            this.listaContracte = this.masterRepo.f();
        }
        return listaContracte;
    }*/

   /* public List<Facturi> getListaFacturi() {
        if (this.listaFacturi == null) {
            this.listaFacturi = this.masterRepo.fi();
        }
        return listaFacturi;
    }*/

    public List<Plati> getListaPlati() {
        if (this.listaPlati == null) {
            this.listaPlati = this.masterRepo.findAllPlati();
        }
        return listaPlati;
    }

    public List<Marketing> getListaMarketing() {
        if (this.listaMarketing == null) {
            this.listaMarketing = this.masterRepo.findAllMarketing();
        }
        return listaMarketing;
    }

    public List<PotentialClienti> getListaPotentialClienti() {
        if (this.listaPotentialClienti == null) {
            this.listaPotentialClienti = this.masterRepo.findAllPotentialClienti();
        }
        return listaPotentialClienti;
    }

    public List<Vanzari> getListaVanzari() {
        if (this.listaVanzari == null) {
            this.listaVanzari = this.masterRepo.findAllVanzari();
        }
        return listaVanzari;
    }

    public List<Vehicule> getListaVehicule() {
        if (this.listaVehicule == null) {
            this.listaVehicule = this.masterRepo.findAllVehiclesLight();
        }
        return listaVehicule;
    }

    public MasterRepository getMasterRepo() {
        return masterRepo;
    }

    public void setMasterRepo(MasterRepository masterRepo) {
        this.masterRepo = masterRepo;
    }

    public DocumentRepository getDocRepo() {
        return docRepo;
    }

    public void setDocRepo(DocumentRepository docRepo) {
        this.docRepo = docRepo;
    }

    public void setListaVehicule(List<Vehicule> allVehicles) {
        this.listaVehicule = allVehicles;
    }
}

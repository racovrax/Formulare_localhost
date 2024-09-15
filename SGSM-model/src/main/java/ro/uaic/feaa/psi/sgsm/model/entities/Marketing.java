package ro.uaic.feaa.psi.sgsm.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import ro.uaic.feaa.psi.metamodel.AbstractEntity;

@Entity
public class Marketing extends AbstractEntity {
    @Column(name = "id_campanie")
    private int idCampanie;

    @Column(name = "materiale_promotionale")
    private String materialePromotionale;

    @Column(name = "strategii")
    private String strategii;

    @Column(name = "sume")
    private double sume;

    @OneToOne
    private Vehicule vehicle;

    // Constructori
    public Marketing() {}

    public Marketing(int idCampanie, String materialePromotionale, String strategii, double sume, Vehicule vehicle) {
        this.idCampanie = idCampanie;
        this.materialePromotionale = materialePromotionale;
        this.strategii = strategii;
        this.sume = sume;
        this.vehicle = vehicle;
    }

    public Marketing(int idCampanie, String strategii) { // Constructor pentru metoda findAllMarketingLight
        this.idCampanie = idCampanie;
        this.strategii = strategii;
    }

    // Getters și Setters
    public int getIdCampanie() {
        return idCampanie;
    }

    public void setIdCampanie(int idCampanie) {
        this.idCampanie = idCampanie;
    }

    public String getMaterialePromotionale() {
        return materialePromotionale;
    }

    public void setMaterialePromotionale(String materialePromotionale) {
        this.materialePromotionale = materialePromotionale;
    }

    public String getStrategii() {
        return strategii;
    }

    public void setStrategii(String strategii) {
        this.strategii = strategii;
    }

    public double getSume() {
        return sume;
    }

    public void setSume(double sume) {
        this.sume = sume;
    }

    public Vehicule getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicule vehicle) {
        this.vehicle = vehicle;
    }
}

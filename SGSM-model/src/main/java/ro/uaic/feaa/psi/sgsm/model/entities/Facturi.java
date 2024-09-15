package ro.uaic.feaa.psi.sgsm.model.entities;

import ro.uaic.feaa.psi.metamodel.AbstractEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Facturi extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String client;
    private String invoiceNumber;
    private String invoiceDate;
    private Double vehiclePrice;
    private Double vat;
    private Double totalInvoice;
    private String detalii;

    @ManyToOne
    private Vehicule vehicle;

    @ManyToOne
    @JoinColumn(name = "plati_id")
    private Plati plati;

    @ManyToOne
    @JoinColumn(name = "contracte_id")
    private Contracte contracte;

    public Facturi() {
    }

    public Facturi(String client, String invoiceNumber, String invoiceDate, Double vehiclePrice, Double vat, Double totalInvoice, Vehicule vehicle,String detalii) {
        this.client = client;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.vehiclePrice = vehiclePrice;
        this.vat = vat;
        this.totalInvoice = totalInvoice;
        this.vehicle = vehicle;
        this.detalii = detalii;
    }

    public Contracte getContracte() {
        return contracte;
    }

    public void setContracte(Contracte contracte) {
        this.contracte = contracte;
    }

    public Plati getPlati() {
        return plati;
    }

    public void setPlati(Plati plati) {
        this.plati = plati;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(Double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public Double getTotalInvoice() {
        return totalInvoice;
    }

    public void setTotalInvoice(Double totalInvoice) {
        this.totalInvoice = totalInvoice;
    }

    public Vehicule getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicule vehicle) {
        this.vehicle = vehicle;
    }

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }


}

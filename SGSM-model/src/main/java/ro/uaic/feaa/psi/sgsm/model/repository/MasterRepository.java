package ro.uaic.feaa.psi.sgsm.model.repository;

import java.util.List;
import ro.uaic.feaa.psi.metamodel.AbstractRepository;
import ro.uaic.feaa.psi.sgsm.model.entities.Angajati;
import ro.uaic.feaa.psi.sgsm.model.entities.Clienti;
import ro.uaic.feaa.psi.sgsm.model.entities.Marketing;
import ro.uaic.feaa.psi.sgsm.model.entities.Plati;
import ro.uaic.feaa.psi.sgsm.model.entities.PotentialClienti;
import ro.uaic.feaa.psi.sgsm.model.entities.Vanzari;
import ro.uaic.feaa.psi.sgsm.model.entities.Vehicule;

public class MasterRepository extends AbstractRepository {

	public Vehicule saveVehicle(Vehicule vehicle) {
		if (vehicle.getId() == null) {
			return (Vehicule) this.create(vehicle);
		} else {
			return (Vehicule) this.update(vehicle);
		}
	}

	public Marketing saveMarketing(Marketing marketing) {
		if (marketing.getId() == null) {
			return (Marketing) this.create(marketing);
		} else {
			return (Marketing) this.update(marketing);
		}
	}

	public Plati savePlati(Plati plati) {
		if (plati.getId() == null) {
			return (Plati) this.create(plati);
		} else {
			return (Plati) this.update(plati);
		}
	}

	public Clienti saveClienti(Clienti clienti) {
		if (clienti.getId() == null) {
			return (Clienti) this.create(clienti);
		} else {
			return (Clienti) this.update(clienti);
		}
	}

	public PotentialClienti savePotentialClienti(PotentialClienti potentialClienti) {
		if (potentialClienti.getId() == null) {
			return (PotentialClienti) this.create(potentialClienti);
		} else {
			return (PotentialClienti) this.update(potentialClienti);
		}
	}

	public Angajati saveAngajati(Angajati angajati) {
		if (angajati.getId() == null) {
			return (Angajati) this.create(angajati);
		} else {
			return (Angajati) this.update(angajati);
		}
	}

	public Vanzari saveVanzari(Vanzari vanzari) {
		if (vanzari.getId() == null) {
			return (Vanzari) this.create(vanzari);
		} else {
			return (Vanzari) this.update(vanzari);
		}
	}

	public Vehicule findVehicleById(Long id) {
		return (Vehicule) this.getEm().find(Vehicule.class, id);
	}

	public Marketing findMarketingById(Long id) {
		return (Marketing) this.getEm().find(Marketing.class, id);
	}

	public Plati findPlatiById(Long id) {
		return (Plati) this.getEm().find(Plati.class, id);
	}

	public Clienti findClientiById(Long id) {
		return (Clienti) this.getEm().find(Clienti.class, id);
	}

	public PotentialClienti findPotentialClientiById(Long id) {
		return (PotentialClienti) this.getEm().find(PotentialClienti.class, id);
	}

	public Angajati findAngajatiById(Long id) {
		return (Angajati) this.getEm().find(Angajati.class, id);
	}

	public Vanzari findVanzariById(Long id) {
		return (Vanzari) this.getEm().find(Vanzari.class, id);
	}

	public List<Vehicule> findAllVehicles() {
		return this.getEm().createQuery("SELECT v FROM Vehicule v", Vehicule.class).getResultList();
	}

	public List<Marketing> findAllMarketing() {
		return this.getEm().createQuery("SELECT m FROM Marketing m", Marketing.class).getResultList();
	}

	public List<Plati> findAllPlati() {
		return this.getEm().createQuery("SELECT p FROM Plati p", Plati.class).getResultList();
	}

	public List<Clienti> findAllClienti() {
		return this.getEm().createQuery("SELECT c FROM Clienti c", Clienti.class).getResultList();
	}

	public List<PotentialClienti> findAllPotentialClienti() {
		return this.getEm().createQuery("SELECT p FROM PotentialClienti p", PotentialClienti.class).getResultList();
	}

	public List<Angajati> findAllAngajati() {
		return this.getEm().createQuery("SELECT a FROM Angajati a", Angajati.class).getResultList();
	}

	public List<Vanzari> findAllVanzari() {
		return this.getEm().createQuery("SELECT v FROM Vanzari v", Vanzari.class).getResultList();
	}

	public void deleteVehicle(Vehicule vehicle) {
		this.delete(vehicle);
	}

	public void deleteMarketing(Marketing marketing) {
		this.delete(marketing);
	}

	public void deletePlati(Plati plati) {
		this.delete(plati);
	}

	public void deleteClienti(Clienti clienti) {
		this.delete(clienti);
	}

	public void deletePotentialClienti(PotentialClienti potentialClienti) {
		this.delete(potentialClienti);
	}

	public void deleteAngajati(Angajati angajati) {
		this.delete(angajati);
	}

	public void deleteVanzari(Vanzari vanzari) {
		this.delete(vanzari);
	}
	public List<Marketing> findAllMarketingLight() {
		return this.getEm().createQuery("SELECT new Marketing(m.idCampanie, m.strategii) FROM Marketing m", Marketing.class).getResultList();
	}

	public List<Vehicule> findAllVehiclesLight() {
		return this.getEm().createQuery(
				"SELECT new Vehicule(v.nume, v.detalii, v.preturi) FROM Vehicule v",
				Vehicule.class).getResultList();
	}

	public List<Vanzari> findAllVanzariLight() {
		return this.getEm().createQuery(
				"SELECT new Vanzari(v.idAngajat, v.idFacturaAsociata, v.idVanzare, v.rapoarteVanzari,v.angajati,v.contracte) FROM Vanzari v",
				Vanzari.class).getResultList();
	}

}

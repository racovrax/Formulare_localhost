package ro.uaic.feaa.psi.sgsm.model.repository;

import ro.uaic.feaa.psi.sgsm.model.entities.Contracte;
import ro.uaic.feaa.psi.sgsm.model.entities.Facturi;
import ro.uaic.feaa.psi.sgsm.model.entities.Vehicule;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DocumentRepository {

	private EntityManagerFactory emf;
	private EntityManager em;

	public DocumentRepository() {
		emf = Persistence.createEntityManagerFactory("SGSMPersistenceUnit");
		em = emf.createEntityManager();
	}

	public Vehicule findVehiculById(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("ID to load is required for loading");
		}
		return em.find(Vehicule.class, id);
	}

	public Facturi findFacturaById(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("ID to load is required for loading");
		}
		return em.find(Facturi.class, id);
	}

	public void saveFactura(Facturi factura) {
		beginTransaction();
		em.merge(factura);
		commitTransaction();
	}

	public void beginTransaction() {
		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}
	}

	public void commitTransaction() {
		if (em.getTransaction().isActive()) {
			em.getTransaction().commit();
		}
	}

	public void rollbackTransaction() {
		if (em.getTransaction().isActive()) {
			em.getTransaction().rollback();
		}
	}

	public void close() {
		em.close();
		emf.close();
	}

	public void saveContract(Contracte contract) {
	}

	public List<Facturi> findAllFacturi() {

		return null;

	}
}

package test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ro.uaic.feaa.psi.sgsm.model.entities.Marketing;
import ro.uaic.feaa.psi.sgsm.model.entities.Vehicule;
import ro.uaic.feaa.psi.sgsm.model.repository.MasterRepository;

public class TestMarketing {

	static MasterRepository repo = new MasterRepository();

	@Test
	public void testMarketing() {
		List<Marketing> x = repo.findAllMarketing();
		if (x.size() == 0) {
			adaugaMarketing();
			x = repo.findAllMarketing();
		}
		System.out.println("##################### Vezi SQL generat deasupra acestei linii și compara cu cel generat dedesubt. " +
				"Atenție la numărul de interogări pe tabela Marketing ############");
		assert x.size() > 0;

		List<Marketing> y = repo.findAllMarketingLight();
		Assert.assertTrue(y.size() == x.size());

		Assert.assertTrue(x.get(0).getStrategii() != null);

        Assert.assertNull("metoda findAllMarketingLight NU trebuie să încarce obiecte Vehicle pentru fiecare marketing", y.getFirst().getMaterialePromotionale());
	}

	public static void adaugaMarketing() {
        int i = 0;
        Vehicule vehicle = new Vehicule( "Caract1", "", 20000.0);
        repo.beginTransaction();
        vehicle = repo.saveVehicle(vehicle);
        repo.commitTransaction();

        Marketing f = null;
        repo.beginTransaction();
        for (i = 1; i <= 3; i++) {
            f = new Marketing(i, "Banner " + i, "Strategie " + i, 10000.0 * i, vehicle);
            f.setIdCampanie(i);
            repo.saveMarketing(f);
        }
        repo.commitTransaction();
    }
}

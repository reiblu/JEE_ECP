package models.daos.jpa.test;

import static org.junit.Assert.*;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.Estudios;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VotoDaoJpaTest {

	private Tema t1;

	private Voto v1;

	private VotoDao dao = DaoJpaFactory.getFactory().getVotoDao();
	private TemaDao dao1 = DaoJpaFactory.getFactory().getTemaDao();

	@BeforeClass
	public static void init() {
		DaoJpaFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
	}

	@Before
	public void init1() {
		t1 = new Tema("¿Te ha gustado?", "Juegos");
		v1 = new Voto(Estudios.ESO, "192.0.0.0", 3, t1);
		dao.create(v1);
		dao1.create(t1);
	}

	@Test
	public void testRead() {
		assertTrue(v1.equals(dao.read(v1.getId())));
	}

	@Test
	public void testUpdate() {
		v1.setValoracion(6);
		dao.update(v1);
		assertTrue(v1.equals(dao.read(v1.getId())));
	}

	@Test
	public void testDeleteByID() {
		Voto v4 = new Voto(Estudios.BACHILLERATO, "192.0.0.0", 9, t1);
		dao.create(v4);
		dao.BorrarVotosdeTema(t1.getId());
		assertNull(dao.read(v4.getId()));
	}

	@Test
	public void testFindAll() {
		assertEquals(1, dao.findAll().size());
	}

}

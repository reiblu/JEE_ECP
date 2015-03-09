package models.daos.jpa.test;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TemaDaoJpaTest {


	private TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();
	private Tema t1;
	
	@Before
	public void init1(){
		t1 = new Tema("¿Te ha gustado?","Juegos");
	}
	
	@BeforeClass
	public void init(){
		DaoFactory factory = null;
		DaoJpaFactory.setFactory(factory);
		DaoJpaFactory.getFactory();
	}

	@Test
	public void testCreate() {
		dao.create(t1);
	}

	@Test
	public void testRead() {
		
	}

	@Test
	public void testUpdate() {
		
	}

	@Test
	public void testDeleteByID() {
		
	}

	@Test
	public void testFindAll() {
		
	}

}

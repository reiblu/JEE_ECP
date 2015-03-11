package models.daos.jpa.test;

import static org.junit.Assert.*;
import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TemaDaoJpaTest {

    private TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();

    private Tema t1;

    @BeforeClass
    public static void init() {
        DaoJpaFactory.setFactory(new DaoJpaFactory());
        DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
    }

    @Before
    public void init1() {
        t1 = new Tema("¿Te ha gustado?", "Juegos");
        dao.create(t1);

    }

    @Test
    public void testCreate() {
        Tema t2 = new Tema("¿Te gusto?", "Mandos");
        dao.create(t2);
        assertEquals(t2, dao.read(t2.getId()));
    }

    @Test
    public void testRead() {
        assertEquals(this.t1, dao.read(t1.getId()));
    }

    @Test
    public void testUpdate() {
        t1.setNombre("Premios");
        dao.update(t1);
        assertEquals(this.t1.getNombre(), dao.read(t1.getId()).getNombre());
    }

    @Test
    public void testDeleteByID() {
        // assertNull
        Tema t4 = new Tema("Â¿Te han gustado?", "Puzzles");
        dao.create(t4);
        dao.deleteByID(t4.getId());
        assertNull(dao.read(t4.getId()));
    }

    @Test
    public void testFindAll() {
        // size
        assertEquals(1, dao.findAll().size());
    }

    @After
    public void after() {
        DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
    }
}

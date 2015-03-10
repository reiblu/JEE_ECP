package models.daos.jpa.test;

import static org.junit.Assert.*;
import models.daos.VotoDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.Estudios;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VotoDaoJpaTest {

    private Tema t1;

    private Voto v1;

    private VotoDao dao = DaoJpaFactory.getFactory().getVotoDao();

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
    }

    @Test
    public void testCreate() {
        Voto v2 = new Voto(Estudios.GRADUADO, "192.0.0.0", 5, t1);
        dao.create(v2);
        assertEquals(v2, dao.read(v2.getId()));
    }

    @Test
    public void testRead() {
        assertEquals(this.v1, dao.read(v1.getId()));
    }

    @Test
    public void testUpdate() {
        v1.setValoracion(6);
        dao.update(v1);
        assertEquals(this.v1, dao.read(v1.getId()));
    }

    @Test
    public void testDeleteByID() {
        Voto v4 = new Voto(Estudios.BACHILLERATO, "192.0.0.0", 9, t1);
        dao.create(v4);
        dao.deleteByID(v4.getId());
        assertNull(dao.read(v4.getId()));
    }

    @Test
    public void testFindAll() {
        assertEquals(2, dao.findAll().size());
    }
    
    @After
    public void after() {
        DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
    }

}

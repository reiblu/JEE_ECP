package models.daos.jpa;

import java.util.logging.LogManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.daos.TemaDao;
import models.daos.VotoDao;

public class DaoJpaFactory {

    private static final String PERSISTENCE_UNIT = "jee_ecp";

    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT);

    public DaoJpaFactory() {
        LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
    
    public TemaDao getTemaDao() {
        return new TemaDaoJpa();
    }

    public VotoDao getVotoDao() {
        return new VotoDaoJpa();
    }
    
}

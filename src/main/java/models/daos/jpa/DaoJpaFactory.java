package models.daos.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;

import org.apache.logging.log4j.LogManager;
import org.eclipse.persistence.config.PersistenceUnitProperties;

public class DaoJpaFactory extends DaoFactory {
	private static final String PERSISTENCE_UNIT = "JEE_ECP";

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public DaoJpaFactory() {
		LogManager.getLogger(DaoJpaFactory.class).debug(
				"create Entity Manager Factory");
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence
					.createEntityManagerFactory(PERSISTENCE_UNIT);
			LogManager.getLogger(DaoJpaFactory.class).debug(
					"create Entity Manager Factory");
		}
		return entityManagerFactory;
	}

	public static void prepareFactoryWithDropAndCreateTables() {
		Map<String, String> properties = new HashMap<>();
		properties.put(PersistenceUnitProperties.DDL_GENERATION,
				PersistenceUnitProperties.DROP_AND_CREATE);
		entityManagerFactory = Persistence.createEntityManagerFactory(
				PERSISTENCE_UNIT, properties);
		LogManager.getLogger(DaoJpaFactory.class).debug(
				"create Entity Manager Factory");
	}

	@Override
	public TemaDao getTemaDao() {
		return new TemaDaoJpa();
	}

	@Override
	public VotoDao getVotoDao() {
		return new VotoDaoJpa();
	}

}

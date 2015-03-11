package models.daos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import models.daos.VotoDao;
import models.entities.Tema;
import models.entities.Voto;

public class VotoDaoJpa extends GenericDaoJpa<Voto, Integer> implements VotoDao {

    public VotoDaoJpa() {
        super(Voto.class);
    }
    
    EntityManager em = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
    CriteriaBuilder criteria = em.getCriteriaBuilder();	
    
    public void BorrarVotosdeTema (Tema tema){
    	
    	em.getTransaction().begin();
    	CriteriaDelete<Voto> borrar = criteria.createCriteriaDelete(Voto.class);
	    Root<Voto> e = borrar.from(Voto.class);
	    borrar.where(criteria.equal(e.get("tema").get("id"), tema.getId()));
	    em.createQuery(borrar).executeUpdate();
	    em.getTransaction().commit();
    	
    }

}

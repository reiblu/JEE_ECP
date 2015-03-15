package models.daos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import models.daos.VotoDao;
import models.entities.Voto;

public class VotoDaoJpa extends GenericDaoJpa<Voto, Integer> implements VotoDao {

    public VotoDaoJpa() {
        super(Voto.class);
    }
    
    EntityManager em = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
    CriteriaBuilder criteria = em.getCriteriaBuilder();	
    
    public void BorrarVotosdeTema (int idTema){
    	
    	em.getTransaction().begin();
    	CriteriaDelete<Voto> borrar = criteria.createCriteriaDelete(Voto.class);
	    Root<Voto> e = borrar.from(Voto.class);
	    borrar.where(criteria.equal(e.get("tema").get("id"), idTema));
	    em.createQuery(borrar).executeUpdate();
	    em.getTransaction().commit();
    	
    }
    
    public int getNumVotos(int idTema){
    	
    	EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
    	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    	CriteriaQuery<Long> query = cb.createQuery(Long.class);

    	Root<Voto> root = query.from(Voto.class);
    	
    	query.select(cb.count(root));
    	Predicate predicate = cb.equal(root.get("voto").get("Tema"),idTema);
        query.where(predicate);
        
    	return entityManager.createQuery(cb).getSingleResult;
    }
    
    public int getValorMedia(int idTema){
    	return 0;
    }

}

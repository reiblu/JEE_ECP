package models.daos.jpa.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import models.entities.Tema;
import models.entities.Voto;
import models.utils.Estudios;

import org.junit.Test;

public class VotoDaoJpaTest {

	 EntityManager em = Persistence.createEntityManagerFactory("JEE_ECP").createEntityManager();
	 
	 Tema t1 = new Tema("¿Te ha gustado?","Juegos");
	 Voto v1 = new Voto(Estudios.ESO, "192.0.0.0", 3, t1);
	
	@Test
	public void testCreate() {
		em.getTransaction().begin();
        em.persist(v1);
        em.persist(new Voto(Estudios.BACHILLERATO, "0.0.0.0", 5,t1));
        em.getTransaction().commit();
	}

	@Test
	public void testRead() {
		Voto v3 = em.find(Voto.class, "192.0.0.0");
    	assertEquals(v3,v1);
	}

	@Test
	public void testUpdate() {
		em.getTransaction().begin();
        Voto v4 = em.merge(new Voto(Estudios.GRADUADO, "0.0.0.0", 5,t1));
        em.getTransaction().commit();
        assertEquals("Voto [ipUsuario=0.0.0.0 valoracion=5 id_tema=" + t1.getId() + "estudios=" + Estudios.GRADUADO + "]",v4);
        
        em.getTransaction().begin();
        v1.setValoracion(7);
        em.getTransaction().commit();
	}

	@Test
	public void testDeleteByID() {
		Query query = em.createQuery("SELECT id FROM voto WHERE ipUsuario='0.0.0.0' AND valoracion='7'");
        int id = query.getFirstResult();
        Voto v2 = em.find(Voto.class, id);
        em.getTransaction().begin();
        em.remove(v2);
        em.getTransaction().commit();
	}

	@Test
	public void testFindAll() {
		Query query = em.createQuery("SELECT e FROM voto e");
   	 	query.getResultList();
	}

}

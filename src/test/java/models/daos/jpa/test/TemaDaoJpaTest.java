package models.daos.jpa.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import models.entities.Tema;

import org.junit.Test;

public class TemaDaoJpaTest {
	
	 EntityManager em = Persistence.createEntityManagerFactory("JEE_ECP").createEntityManager();
	 
	 Tema t1 = new Tema("�Te ha gustado?","Juegos");

    @Test
    public void testCreate() {
    	em.getTransaction().begin();
        em.persist(t1);
        em.persist(new Tema("�Te ha gustado?","Mandos"));
        em.getTransaction().commit();
    }

    @Test
    public void testRead() {
    	em.find(Tema.class, "�Te ha gustado?");
    	
    }

    @Test
    public void testUpdate() {
    	em.getTransaction().begin();
        em.merge(new Tema("�Te ha gustado1?","Mandos"));
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        t1.setPregunta("�Te gusto?");
        em.getTransaction().commit();
    }

    @Test
    public void testDeleteByID() {
        Query query = em.createQuery("SELECT id FROM tema WHERE prgunta='�Te gusto?' AND nombre='Juegos'");
        int id = query.getFirstResult();
        Tema t2 = em.find(Tema.class, id);
        em.getTransaction().begin();
        em.remove(t2);
        em.getTransaction().commit();
        
    }

    @Test
    public void testFindAll() {
    	 Query query = em.createQuery("SELECT e FROM tema e");
    	 query.getResultList();
    }

}

package models.daos.jpa.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import models.entities.Tema;

import org.junit.BeforeClass;
import org.junit.Test;

public class TemaDaoJpaTest {

	private EntityManager em;
	private Tema t1;

	@BeforeClass
	public void init() {
		this.em = Persistence.createEntityManagerFactory("JEE_ECP")
				.createEntityManager();
		this.t1 = new Tema("풲e ha gustado?", "Juegos");
		em.getTransaction().begin();
		em.persist(t1);
		em.getTransaction().commit();
	}

	@Test
	public void testCreate() {
		em.getTransaction().begin();
		em.persist(new Tema("풲e ha gustado?", "Mandos"));
		em.getTransaction().commit();
	}

	@Test
	public void testRead() {
		Tema t3 = em.find(Tema.class, "풲e ha gustado?");
		assertEquals(t3, t1);
	}

	@Test
	public void testUpdate() {
		em.getTransaction().begin();
		Tema t4 = em.merge(new Tema("풲e ha gustado1?", "Mandos"));
		em.getTransaction().commit();
		assertEquals("Tema [nombre=Mandos pregunta=풲e ha gustado1?]", t4);

		em.getTransaction().begin();
		t1.setPregunta("풲e gusto?");
		em.getTransaction().commit();
	}

	@Test
	public void testDeleteByID() {
		Query query = em
				.createQuery("SELECT id FROM tema WHERE pregunta='풲e gusto?' AND nombre='Juegos'");
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

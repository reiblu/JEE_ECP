package models.daos.jdbc;

import java.util.List;

import models.daos.VotoDao;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.Estudios;

public class VotoDaoJdbc extends GenericDaoJdbc<Voto, Integer> implements
		VotoDao {

	public void create(Tema entity) {

	}

	@Override
	public void deleteByID(Integer id) {

	}

	public List<Voto> findAll() {

		return null;
	}

	public static String sqlToCreateTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Voto entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Voto read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Voto entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void BorrarVotosdeTema(int idTema) {
		// TODO Auto-generated method stub

	}

	@Override
	public long getNumVotos(int idTema) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getValoracionMedia(int idTema, Estudios estudio) {
		// TODO Auto-generated method stub
		return 0;
	}

}

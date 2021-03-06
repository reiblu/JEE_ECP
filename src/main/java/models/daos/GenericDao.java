package models.daos;

import java.util.List;

public interface GenericDao<T, ID> {

    public void create(T entity);

    public T read(ID id);

    public void update(T entity);

    public void deleteByID(ID id);

    public List<T> findAll();

}

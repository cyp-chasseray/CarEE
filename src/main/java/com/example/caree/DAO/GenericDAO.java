package com.example.caree.DAO;
import java.util.List;

public interface GenericDAO<T> {

    public void create(T object);

    public List<T> fetchAll();

    public T fetchOne(int id);

    public void update(int id);
    public void delete(int id);
}

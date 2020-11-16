package by.grodno.nosevich.webapp.service;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();
    void add(T ob);
    T getById(int id);
    void update(T ob);
    void delete(T ob);
}
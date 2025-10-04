package ir.mzahrani.service;

import java.util.List;

public interface ServiceInterface<T,ID> {

    T create(T entity);

    T update(T entity);

    void delete(ID id);

    T get(ID id);

//    List<T> getAll();
}

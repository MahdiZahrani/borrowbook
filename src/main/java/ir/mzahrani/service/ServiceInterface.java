package ir.mzahrani.service;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface<T,ID> {

    T create(T entity);

    T update(T entity);

    void delete(ID id);

    Optional<T> get(ID id);

    List<T> getAll();
}

package binaryclown.petprojects.rest.notesappserver.daos;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(long id);

    List<?> getAll();

    void save(T entity);

    T update(T entity);

    void delete(T entity);
}

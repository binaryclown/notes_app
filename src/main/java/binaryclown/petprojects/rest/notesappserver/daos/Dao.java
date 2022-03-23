package binaryclown.petprojects.rest.notesappserver.daos;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(long id);

    List<T> getAll();

    void save(T t);

    T update(T t);

    void delete(T t);
}
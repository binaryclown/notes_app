package binaryclown.petprojects.rest.notesappserver.daos.impl;

import binaryclown.petprojects.rest.notesappserver.daos.Dao;
import binaryclown.petprojects.rest.notesappserver.entities.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class NoteDaoImpl implements Dao<Note> {

    //QUERY
    private static final String GET_LIST_NOTES_QUERY = "SELECT notes FROM Note notes";

    private final EntityManager entityManager;

    @Autowired
    public NoteDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Note> get(long id) {
        return Optional.ofNullable(entityManager.find(Note.class, id));
    }

    @Override
    public List<?> getAll() {
        Query queryGetAll = entityManager.createQuery(GET_LIST_NOTES_QUERY);
        return queryGetAll.getResultList();
    }

    @Override
    @Transactional
    public void save(Note note) {
        entityManager.persist(note);
    }

    @Override
    @Transactional
    public Note update(Note note) {
        return entityManager.merge(note);
    }

    @Override
    public void delete(Note note) {
        entityManager.remove(note);
    }
}

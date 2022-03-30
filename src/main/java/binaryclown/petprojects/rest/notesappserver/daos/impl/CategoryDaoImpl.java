package binaryclown.petprojects.rest.notesappserver.daos.impl;

import binaryclown.petprojects.rest.notesappserver.daos.Dao;
import binaryclown.petprojects.rest.notesappserver.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryDaoImpl implements Dao<Category> {

    //QUERY
    private static final String GET_LIST_CATEGORIES_QUERY = "SELECT categories FROM Category categories";

    private final EntityManager entityManager;

    @Autowired
    public CategoryDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Category> get(long id) {
        return Optional.ofNullable(entityManager.find(Category.class, id));
    }

    @Override
    public List<?> getAll() {
        Query queryGetAll = entityManager.createQuery(GET_LIST_CATEGORIES_QUERY);
        return queryGetAll.getResultList();
    }

    @Override
    @Transactional
    public void save(Category category) {
        entityManager.persist(category);
    }

    @Override
    @Transactional
    public Category update(Category category) {
        return entityManager.merge(category);
    }

    @Override
    public void delete(Category category) {
        entityManager.remove(category);
    }

}

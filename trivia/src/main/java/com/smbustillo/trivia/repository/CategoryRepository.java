package com.smbustillo.trivia.repository;

import com.smbustillo.trivia.entities.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CategoryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Category> getAll() {
        return null;
    }

    public Category getCategoryById(Integer id){
        return entityManager.find(Category.class,id);
    }
}

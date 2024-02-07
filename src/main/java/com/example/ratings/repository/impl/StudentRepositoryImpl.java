package com.example.ratings.repository.impl;

import com.example.ratings.models.Student;
import com.example.ratings.repository.IRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Slf4j
@Repository
@Qualifier("student")
public class StudentRepositoryImpl implements IRepository<Student, UUID> {
    @PersistenceContext
    private final EntityManager entityManager;

    public StudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public Student save(Student entity) {
        try {
            entityManager.persist(entity);
            return entity;
        } catch (PersistenceException ex) {
            log.error("Could not create a new student data in db", ex);
            return null;
        }
    }
    @Override
    public Student save(UUID id, Student entity) {
        try {
            Student studentExisting = findById(id);
            if (studentExisting != null) {
                studentExisting.setName(entity.getName());
                studentExisting.setEmail(entity.getEmail());
                studentExisting.setPhone_number(entity.getPhone_number());
                studentExisting.setAddress(entity.getAddress());
                entityManager.merge(studentExisting);
            }
            return studentExisting;
        } catch (PersistenceException ex) {
            log.error("Could not update student data in db");
            return null;
        }
    }

    @Override
    public Student findById(UUID id) {

        return entityManager.createQuery("select  e FROM Student e where e.id=:id", Student.class)
                .setParameter("id", id).getResultList().stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Student> findAll() {

        try {
            return entityManager.createQuery("select  e FROM Student e", Student.class)
                    .getResultList();
        } catch (PersistenceException ex) {

            return null;
        }
    }

    @Override
    public Student deleteById(UUID id) {
        try {
            return entityManager.createQuery("select  e FROM Student e where e.id=:id", Student.class)
                    .setParameter("id", id).getSingleResult();

        } catch (NoResultException ex) {
            //log

            return null;
        }
    }
}

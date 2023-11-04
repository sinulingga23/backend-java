package org.sinulingga;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.sinulingga.entity.Category;

import java.util.UUID;

public class Main {
    private static final String persistenceUnitName = "org.sinulingga.hibernate";

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        if (entityManagerFactory != null) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();


            Category electronicCategory = new Category();
            electronicCategory.setId(UUID.randomUUID().toString());
            electronicCategory.setName("Electronic");
            electronicCategory.setDescription("Description Electronic");
            entityManager.persist(electronicCategory);

            Category fashionCategory = new Category();
            fashionCategory.setId(UUID.randomUUID().toString());
            fashionCategory.setName("Fashion");
            fashionCategory.setDescription("Description Fashion");
            entityManager.persist(fashionCategory);

            Category healthCategory = new Category();
            healthCategory.setId(UUID.randomUUID().toString());
            healthCategory.setName("Health");
            healthCategory.setDescription("Description Health");
            entityManager.persist(healthCategory);

            entityManager.getTransaction().commit();
            entityManager.close();;
        }
    }
}
package org.sinulingga;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.sinulingga.definition.Status;
import org.sinulingga.entity.Category;
import org.sinulingga.entity.Product;

import java.util.Objects;
import java.util.UUID;

public class Main {
    private static final String persistenceUnitName = "org.sinulingga.hibernate";

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        if (!Objects.isNull(entityManagerFactory)) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            Category categoryElectronic = new Category(
                    UUID.randomUUID().toString(),
                    "Electronic",
                    "CTG001",
                    "Description Electronic");
            entityManager.persist(categoryElectronic);

            Category categoryHealth = new Category(
                    UUID.randomUUID().toString(),
                    "Health",
                    "CTG002",
                    "Description Health"

            );
            entityManager.persist(categoryElectronic);

            Category categoryTechnology = new Category(
                    UUID.randomUUID().toString(),
                    "Technology",
                    "CTG003",
                    "Description Technology"
            );
            entityManager.persist(categoryTechnology);

            Product productLaptop = new Product(
                    UUID.randomUUID().toString(),
                    "Laptop",
                    "PDC00001",
                    Long.valueOf(123),
                    Status.ACTIVE
            );

            productLaptop.addCategory(categoryElectronic);
            productLaptop.addCategory(categoryTechnology);
            entityManager.persist(productLaptop);


            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
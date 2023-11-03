package org.sinulingga;


import org.sinulingga.dao.CategoryDao;
import org.sinulingga.db.ConnectionDB;
import org.sinulingga.model.Category;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class Main {
   public static void main(String []args) {
       Connection connection = ConnectionDB.getConnection();

       CategoryDao categoryDao = new CategoryDao(connection);

       // add category
       categoryDao.add(new Category(UUID.randomUUID().toString(), "Category 1", "Description 1"));

       // find all category
       List<Category> listCategory = categoryDao.findAll();

       // find a category
       Category category = categoryDao.findOne(listCategory.get(0).getId());

       // delete a category
       categoryDao.deleteById(category.getId());
    }
}
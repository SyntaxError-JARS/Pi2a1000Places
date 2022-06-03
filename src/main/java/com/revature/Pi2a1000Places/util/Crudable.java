package com.revature.Pi2a1000Places.util;

public interface Crudable<T> {
//CRUD: Create, Read, Update, Delete

    T create(T newObject);

    T readById(String userName);

    T findById(String username);
    boolean update(T updatedObject);
    boolean delete(String username);
}         //or CreditCard?

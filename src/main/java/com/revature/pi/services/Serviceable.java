package com.revature.pi.services;

public interface Serviceable<T> {
    //Create, Read, Update, Delete.

    T create(T newObject);

    //
    T[] readAll();
    T readByUserName(String userName);
    // T readById(String id); Add instaed of RBU, or keep both?

    //
    T update(T updatedObject);
    //public boolean update(T update Object);

    boolean delete(String id);

    boolean validateInput(T object);
}

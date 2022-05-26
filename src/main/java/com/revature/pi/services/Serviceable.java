package com.revature.pi.services;

public interface Serviceable<T> {
    //Create, Read, Update, Delete Functions.

    T create(T newObject);

    //
    T[] readAll();
    T readByUserName(String userName);

    //
    T update(T updatedObject);

    //
    boolean delete(String id);

    boolean validateInput(T object);
}

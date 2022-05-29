package com.revature.Pi2a1000Places.util;

import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;

import java.io.IOException;
import java.sql.SQLException;

public interface Crudable<T> {
//CRUD: Create, Read, Update, Delete

    T create(T newObject) throws SQLException;

    //check exception thrown. Necessary?
    default T[] findAll() throws IOException {
        return null;
    }
    T findById(String username);
                    boolean update(T updatedObject);
                    boolean delete(String username);
}                                      //or CreditCard?

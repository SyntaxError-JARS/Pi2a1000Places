package com.revature.pi.daos;

import java.io.IOException;
import java.sql.SQLException;

public interface Crudable<T> {
//CRUD: Create, Read, Update, Delete

    T create(T newObject) throws SQLException;
//check exception thrown. Necessary?


    T[] findAll() throws IOException;
    T findById(String id);

    boolean update(T updatedObject);

    boolean delete(String id);
}

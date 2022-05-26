package com.revature.pi.daos;

import java.io.IOException;
import java.sql.SQLException;

public interface Crudable<T> {


    T create(T newCustomer) throws SQLException;

    T[] findAll() throws IOException;
    T findById(String id);

    boolean update(T updatedObject);

    boolean delete(String id);
}

package model;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author maria
 */
public interface Dao<T, R> {

    T get(R id) throws ElementNotFound;

    List<T> getAll() throws ElementNotFound;

    boolean save(T t) throws ElementFound;

    boolean delete(R t) throws ElementNotFound;

}

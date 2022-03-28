package model;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author maria
 */
public interface Dao<T, R> {
    
    T get(R id);
    
    List<T> getAll();
    
    boolean save(T t);
        
    void delete(T t);
    
}

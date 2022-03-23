package model;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author maria
 */
public interface Dao<T> {
    
    T get(long id);
    T get(String email);
    
    List<T> getAll();
    
    void save(T t);
        
    void delete(T t);
    
}

package base.badmoviesql.dao.mapper;

import base.badmoviesql.model.Director;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorMapper {
    Director getDirector(int ID);
    int addDirector(int ID);
    void updateDirector(int ID);
    void deleteDirector (int ID);


}

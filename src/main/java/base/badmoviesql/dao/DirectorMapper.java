package base.badmoviesql.dao;

import base.badmoviesql.model.Director;

public interface DirectorMapper {
    Director getDirector(int ID);
    Director addDirector(int ID);
    Director updateDirector(int ID);
    Director deleteDirector (int ID);


}

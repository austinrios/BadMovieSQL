package base.badmoviesql.dao;

import base.badmoviesql.model.Movie;

public interface MovieMapper {
    Movie getMovie(int ID);
    Movie addMovie(int ID);
    Movie updateMovie(int ID);
    Movie deleteMovie (int ID);
}

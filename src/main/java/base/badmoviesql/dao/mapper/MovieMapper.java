package base.badmoviesql.dao.mapper;

import base.badmoviesql.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieMapper {

    Movie getMovie(int ID);
    List<Movie> getAllMovies();
    int addMovie(int ID);
    void updateMovie(int ID);
    void deleteMovie (int ID);
}

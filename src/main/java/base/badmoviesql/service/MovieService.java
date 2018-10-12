package base.badmoviesql.service;

import base.badmoviesql.dao.mapper.MovieMapper;
import base.badmoviesql.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService{

    @Autowired
    public MovieMapper movieMapper;


    public Movie getMovie(int id){
        return movieMapper.getMovie(id);
    }

    public int addMovie(int id){
        return movieMapper.addMovie(id);
    }

    public void updateMovie (int id){
        movieMapper.updateMovie(id);
    }

    public void deleteMovie(int id){
        movieMapper.deleteMovie(id);
    }

    public List<Movie> getAllMovies(){
        List<Movie> movies = (List<Movie>) movieMapper.getAllMovies();

        return movies;
    }
}

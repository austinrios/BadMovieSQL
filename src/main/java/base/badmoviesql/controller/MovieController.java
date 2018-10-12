package base.badmoviesql.controller;



import base.badmoviesql.model.Movie;
import base.badmoviesql.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController extends BaseController <Movie> {
    @Autowired
    public MovieService movieService;

    @RequestMapping(produces = "application/json", method = RequestMethod.GET )
    public List<Movie> getAllMovies(){

        return movieService.getAllMovies();
    }
}

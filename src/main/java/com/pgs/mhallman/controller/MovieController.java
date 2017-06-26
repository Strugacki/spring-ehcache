package com.pgs.mhallman.controller;

import com.pgs.mhallman.dao.MovieDao;
import com.pgs.mhallman.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mhallman on 26.06.2017.
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieDao movieDao;

    @GetMapping("find")
    public List<Movie> fetchMovie(@RequestParam("director") String director) {
        return movieDao.findByDirector(director);
    }

    @GetMapping("refresh")
    public void refreshCache() {
        movieDao.refreshCache();
    }

    @PostMapping("add")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieDao.addMovie(movie);
    }

    @GetMapping("all")
    public List<Movie> getAllMovies() {
        return movieDao.getAll();
    }

}

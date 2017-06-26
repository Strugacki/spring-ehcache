package com.pgs.mhallman.dao;

import com.pgs.mhallman.domain.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mhallman on 26.06.2017.
 */
@Repository("movieDao")
public class MovieDao {

    private static final Logger LOG = LoggerFactory.getLogger(MovieDao.class);

    public ArrayList<Movie> movies = new ArrayList<>();

    //This "movieFindCache" is delcares in ehcache.xml
    @Cacheable(value="movies", key="#name")
    public List<Movie> findByDirector(String name) {
        slowQuery(2000L);
        LOG.info("MovieDao :: findByDirector");
        ArrayList<Movie> result = new ArrayList<Movie>();
        for(Movie movie : movies) {
            if (movie.getDirectory().contains(name)) {
                result.add(movie);
            }
        }
        return result;
        //return new Movie(1,"Forrest Gump","Robert Zemeckis");
    }

    @CacheEvict(value = "movies", allEntries = true)
    public void refreshCache() {
        LOG.info("MovieDao :: refreshCash");
    }

    @CachePut(value = "movies", key="#movie")
    public Movie addMovie(Movie movie) {
        LOG.info("MovieDao :: addMovie");
        slowQuery(2000L);
        movies.add(movie);
        return movie;
    }

    @Cacheable(value = "movies")
    public List<Movie> getAll() {
        LOG.info("MovieDao :: getAll");
        slowQuery(2000L);
        return movies;
    }

    private void slowQuery(long seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}

package dev.note.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//this will use to write database Accessmethods
//in here we type most of the business logic
// the service class use the repository class and talk to the db to get the data
@Service
public class MovieService {
    @Autowired // you have to initialized it using a constructor or use this anotation here
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbId){ //we use Optional here cause id can be null
        return movieRepository.findMovieByImdbId(imdbId);
    }
}

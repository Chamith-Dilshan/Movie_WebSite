package dev.note.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//repository class are interface class
//this is the data accessing layer, it will actually talk to the db and get the data
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {  //Movie - Movie model class to tell what kind of data use, ObjectId - type of the id we are using
    Optional<Movie> findMovieByImdbId(String imdbId); //you can use dynamic query like this using any property name
}

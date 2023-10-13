package dev.note.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate; // MongoTemplate use when you have more complex query needs to be done
    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class) // tell to apdate the Movie class
                .matching(Criteria.where("imdbId").is(imdbId)) // check whether the imdbId reserved by user match the database imdbId
                .apply(new Update().push("reviewIds").value(review)) // apply the changes
                .first();

        return review;
    }
}

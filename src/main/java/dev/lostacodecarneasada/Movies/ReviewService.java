package dev.lostacodecarneasada.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReviewBy(String reviewBody, String imdbId){
            Review review = new Review(reviewBody);
            reviewRepository.insert(review);

            mongoTemplate.update(Movie.class)
                    .matching(Criteria.where("imdbId").is(imdbId))


    };
}

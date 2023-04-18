package dev.lostacodecarneasada.Movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collation = "movies")  // this is that this class represents each document in the movies collection.
@Data // takes care all the getters,setters,and to string methods etc.
@AllArgsConstructor // creates a constructor that takes all the below private fields as an argument.
@NoArgsConstructor // another constructor that takes no parameters what's so ever.
public class Movie {

    @Id // this tell the code to treat the id as a unique identifier.
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference                           // This will cause to only store the Ids of the reviews and the reviews in a separate collection --> Also called manual reference relationshiop
    private List<Review> reviewIds;              // This is an inbeded relationship because we created another class for the type list with properties.


}

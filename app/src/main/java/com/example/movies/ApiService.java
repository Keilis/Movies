package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie?token=ASTCMQC-JGJ45DT-PC2MGJ4-G8WA7WZ&field=rating.kp&search=7-10&sortField=votes.kp&sortType=-1&limit=20")
    Single<MovieResponse> loadMovies(@Query("page") int page);

    @GET("movie?token=ASTCMQC-JGJ45DT-PC2MGJ4-G8WA7WZ&field=id")
    Single<TrailerResponse> loadTrailers(@Query("search") int id);

    @GET("review?token=ASTCMQC-JGJ45DT-PC2MGJ4-G8WA7WZ&field=movieId")
    Single<ReviewsResponse> loadReviews(@Query("search") int id);
}

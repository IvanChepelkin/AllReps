package com.example.user.allreps.rest;

import com.example.user.allreps.model.RepsModel;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EndPoints {
    @GET("/users/{user}/repos")
    Flowable<List<RepsModel>> getRepos(
            @Path("user") String user);
}

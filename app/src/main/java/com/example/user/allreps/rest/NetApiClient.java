package com.example.user.allreps.rest;

import com.example.user.allreps.model.RepsModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NetApiClient {
    private static final NetApiClient ourInstance = new NetApiClient();

    public static NetApiClient getInstance() {
        return ourInstance;
    }

    // возвр объект с  методами для выхода в сеть
    private EndPoints netApi = new ServiceGenerator().createService(EndPoints.class);

    private NetApiClient() {
    }

    public Flowable<List<RepsModel>> getReps(String user) {
        return netApi.getRepos(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}

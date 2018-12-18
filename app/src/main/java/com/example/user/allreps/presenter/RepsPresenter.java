package com.example.user.allreps.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.user.allreps.model.RepsModel;
import com.example.user.allreps.rest.NetApiClient;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

@InjectViewState

public class RepsPresenter extends MvpPresenter<RepsView> implements Subscriber<List<RepsModel>> {
    @Override
    public void attachView(RepsView view) {
        //Привязываем View к Presenter
        super.attachView(view);
        //getViewState - доступ к экз ViewState
        getViewState().startLoad();
        loadData();

    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(List<RepsModel> repsModels) {
        getViewState().setListReps(repsModels);
        Log.d("Dto", "size = " + repsModels.size());
    }

    @Override
    public void onError(Throwable t) {
        getViewState().showError(t);
        getViewState().finishLoad();
    }

    @Override
    public void onComplete() {

    }

    private void loadData() {
        getViewState().startLoad();
        NetApiClient.getInstance().getReps("IvanChepelkin").subscribe(this);
    }


}

package com.example.user.allreps.presenter;

import com.arellomobile.mvp.MvpView;
import com.example.user.allreps.model.RepsModel;

import java.util.List;

public interface RepsView extends MvpView {
    void showError(Throwable e);

    void setListReps(List<RepsModel> repsModels);

    void startLoad();

    void finishLoad();
}

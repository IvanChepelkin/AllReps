package com.example.user.allreps.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.user.allreps.R;
import com.example.user.allreps.model.RepsModel;
import com.example.user.allreps.presenter.RepsPresenter;
import com.example.user.allreps.presenter.RepsView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends MvpAppCompatActivity implements RepsView {
    // находим вью
    @InjectPresenter
    RepsPresenter repsPresenter;

    @BindView(R.id.TextNick)
    EditText TextNick;
    @BindView(R.id.RecView)
    RecyclerView RecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Привязываем наши вюшки к этому классу
        ButterKnife.bind(this);
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setListReps(List<RepsModel> repsModels) {
        RecView.setLayoutManager(new LinearLayoutManager(this));
        RecView.setHasFixedSize(false);
        RecViewAdapter recViewAdapter = new RecViewAdapter(repsModels);
        RecView.setAdapter(recViewAdapter);

    }

    @Override
    public void startLoad() {

    }

    @Override
    public void finishLoad() {

    }
}

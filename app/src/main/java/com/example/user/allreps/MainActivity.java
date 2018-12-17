package com.example.user.allreps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MvpAppCompatActivity {
    // находим вью
    @BindView (R.id.TextNick)  EditText TextNick;
    @BindView (R.id.RecView) RecyclerView RecView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Привязываем наши вюшки к этому классу
        ButterKnife.bind(this);
        initRecyclerView();
    }
    public void initRecyclerView(){
        RecView.setLayoutManager(new LinearLayoutManager(this));
        RecView.setHasFixedSize(false);
        RecViewAdapter recViewAdapter = new RecViewAdapter();
        RecView.setAdapter(recViewAdapter);
    }
}

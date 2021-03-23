package com.test.databindingtest0322;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import com.test.databindingtest0322.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    UserViewModel userViewModel;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ActivityMainBinding dataBindingUtil= DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);
        userViewModel=new UserViewModel(dataBindingUtil);
        progressBar=findViewById(R.id.progressBar);
    }
    @Override
    protected void onStart() {
        super.onStart();
        userViewModel.init();
    }
    public void click(View view) {
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                userViewModel.login();
                progressBar.setVisibility(View.GONE);
            }
        },2000);
    }
}
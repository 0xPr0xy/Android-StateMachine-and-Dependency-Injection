package com.example.peterijlst.architecture.two;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.peterijlst.architecture.R;
import com.example.peterijlst.architecture.application.MyApplication;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {

    @Inject SecondActivityController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        controller.announce(findViewById(android.R.id.content));

        final MyApplication application = (MyApplication) getApplication();

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                application.stateMachine.nextState();
            }
        });
    }

}

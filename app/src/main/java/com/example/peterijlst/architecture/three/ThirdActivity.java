package com.example.peterijlst.architecture.three;

import android.app.Activity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.peterijlst.architecture.R;
import com.example.peterijlst.architecture.application.MyApplication;

import javax.inject.Inject;

public class ThirdActivity extends AppCompatActivity {

    @Inject
    protected ThirdActivityController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        controller.announce(findViewById(android.R.id.content));

        final MyApplication application = (MyApplication) getApplication();
        final Activity current = this;

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                application.stateMachine.nextActivity(current);
            }
        });
    }
}

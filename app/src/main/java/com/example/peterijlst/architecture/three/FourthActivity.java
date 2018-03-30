package com.example.peterijlst.architecture.three;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.peterijlst.architecture.R;
import com.example.peterijlst.architecture.application.MyApplication;

import javax.inject.Inject;

public class FourthActivity extends AppCompatActivity {

    @Inject
    protected FourthActivityController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        controller.announce(findViewById(android.R.id.content));

        final MyApplication application = (MyApplication) getApplication();

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                application.stateMachine.previousState();
            }
        });
    }

}

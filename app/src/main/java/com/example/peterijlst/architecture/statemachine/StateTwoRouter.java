package com.example.peterijlst.architecture.statemachine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.peterijlst.architecture.two.SecondActivity;

/**
 * Created by peter.ijlst on 30/03/2018.
 */

public class StateTwoRouter implements Router {
    @Override
    public void route(Context context) {
        Intent initialIntent = new Intent(context, SecondActivity.class);
        context.startActivity(initialIntent);
    }

    @Override
    public void route(Activity from) {

    }
}

package com.example.peterijlst.architecture.statemachine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.peterijlst.architecture.three.FourthActivity;
import com.example.peterijlst.architecture.three.ThirdActivity;

/**
 * Created by peter.ijlst on 30/03/2018.
 */

public class StateThreeRouter implements Router {
    @Override
    public void route(Context context) {
        Intent initialIntent = new Intent(context, ThirdActivity.class);
        context.startActivity(initialIntent);
    }

    @Override
    public void route(Activity from) {
        if (from instanceof ThirdActivity) {
            Intent initialIntent = new Intent(from, FourthActivity.class);
            from.startActivity(initialIntent);
        }
    }
}

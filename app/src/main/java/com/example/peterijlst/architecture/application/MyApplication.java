package com.example.peterijlst.architecture.application;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.example.peterijlst.architecture.MainActivity;
import com.example.peterijlst.architecture.statemachine.StateMachine;

/**
 * Created by peter.ijlst on 30/03/2018.
 */

public class MyApplication extends Application implements Application.ActivityLifecycleCallbacks {

    public StateMachine stateMachine;

    @Override
    public void onCreate() {
        super.onCreate();
        stateMachine = new StateMachine(this);
        registerActivityLifecycleCallbacks(this);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity instanceof MainActivity) {
            this.stateMachine.initialState(activity);
        } else {
            this.stateMachine.activityStarted(activity);
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}

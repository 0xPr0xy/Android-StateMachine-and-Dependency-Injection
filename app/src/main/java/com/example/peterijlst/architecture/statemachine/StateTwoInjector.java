package com.example.peterijlst.architecture.statemachine;

import android.app.Activity;

import com.example.peterijlst.architecture.statemachine.containers.DaggerStateTwoComponent;
import com.example.peterijlst.architecture.statemachine.containers.StateTwoComponent;
import com.example.peterijlst.architecture.statemachine.containers.StateTwoContainer;
import com.example.peterijlst.architecture.two.SecondActivity;

public class StateTwoInjector implements Injector {
    @Override
    public void inject(Activity activity) {
        StateTwoComponent component = DaggerStateTwoComponent
                .builder()
                .stateTwoContainer(new StateTwoContainer())
                .build();
        if (activity instanceof SecondActivity) {
            component.inject((SecondActivity) activity);
        }
    }
}

package com.example.peterijlst.architecture.statemachine;

import android.app.Activity;

import com.example.peterijlst.architecture.statemachine.containers.DaggerStateThreeComponent;
import com.example.peterijlst.architecture.statemachine.containers.StateThreeComponent;
import com.example.peterijlst.architecture.statemachine.containers.StateThreeContainer;
import com.example.peterijlst.architecture.three.FourthActivity;
import com.example.peterijlst.architecture.three.ThirdActivity;

public class StateThreeInjector implements Injector {
    @Override
    public void inject(Activity activity) {
        StateThreeComponent component = DaggerStateThreeComponent
                .builder()
                .stateThreeContainer(new StateThreeContainer())
                .build();
        if (activity instanceof ThirdActivity) {
            component.inject((ThirdActivity) activity);
        } else if (activity instanceof FourthActivity) {
            component.inject((FourthActivity) activity);
        }
    }
}

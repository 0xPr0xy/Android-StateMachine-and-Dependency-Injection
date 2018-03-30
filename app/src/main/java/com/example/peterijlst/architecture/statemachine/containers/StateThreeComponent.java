package com.example.peterijlst.architecture.statemachine.containers;

import com.example.peterijlst.architecture.three.FourthActivity;
import com.example.peterijlst.architecture.three.ThirdActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by peter.ijlst on 30/03/2018.
 */

@Singleton
@Component(modules = {StateThreeContainer.class})
public interface StateThreeComponent {
    void inject(ThirdActivity activity);
    void inject(FourthActivity activity);
}

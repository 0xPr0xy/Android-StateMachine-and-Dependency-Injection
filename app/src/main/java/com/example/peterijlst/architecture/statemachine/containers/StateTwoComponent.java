package com.example.peterijlst.architecture.statemachine.containers;

import com.example.peterijlst.architecture.two.SecondActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by peter.ijlst on 30/03/2018.
 */

@Singleton
@Component(modules = {StateTwoContainer.class})
public interface StateTwoComponent {
    void inject(SecondActivity activity);
}

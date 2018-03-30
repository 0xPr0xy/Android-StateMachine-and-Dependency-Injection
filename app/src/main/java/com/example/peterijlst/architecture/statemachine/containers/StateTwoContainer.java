package com.example.peterijlst.architecture.statemachine.containers;

import com.example.peterijlst.architecture.two.SecondActivityController;
import com.example.peterijlst.architecture.two.SecondActivityService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by peter.ijlst on 30/03/2018.
 */

@Module
public class StateTwoContainer {

    @Provides static SecondActivityController provideSecondActivityController(SecondActivityService service) {
        return new SecondActivityController(service);
    }

    @Provides static SecondActivityService provideSecondActivityService() {
        return new SecondActivityService();
    }
}

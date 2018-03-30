package com.example.peterijlst.architecture.statemachine.containers;

import com.example.peterijlst.architecture.three.ThirdActivityController;
import com.example.peterijlst.architecture.three.ThirdActivityService;

import dagger.Module;
import dagger.Provides;

@Module
public class StateThreeContainer {

    @Provides static ThirdActivityController provideThirdActivityController(ThirdActivityService service) {
        return new ThirdActivityController(service);
    }

    @Provides static ThirdActivityService provideThirdActivityService() {
        return new ThirdActivityService();
    }
}

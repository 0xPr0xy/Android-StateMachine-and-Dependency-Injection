package com.example.peterijlst.architecture.statemachine.containers;

import com.example.peterijlst.architecture.three.FourthActivityController;
import com.example.peterijlst.architecture.three.FourthActivityService;
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

    @Provides static FourthActivityController provideFourthActivityController(FourthActivityService service) {
        return new FourthActivityController(service);
    }

    @Provides static FourthActivityService provideFourthActivityService() {
        return new FourthActivityService();
    }
}

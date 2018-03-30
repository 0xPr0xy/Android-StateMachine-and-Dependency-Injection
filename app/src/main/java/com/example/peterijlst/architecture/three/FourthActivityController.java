package com.example.peterijlst.architecture.three;

import android.view.View;

/**
 * Created by peter.ijlst on 30/03/2018.
 */

public class FourthActivityController {

    private FourthActivityService service;

    public FourthActivityController(FourthActivityService service) {
        this.service = service;
    }

    public void announce(View view) {
        this.service.speak(view);
    }

}

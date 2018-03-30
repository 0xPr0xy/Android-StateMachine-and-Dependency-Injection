package com.example.peterijlst.architecture.two;

import android.view.View;

/**
 * Created by peter.ijlst on 30/03/2018.
 */

public class SecondActivityController {

    private SecondActivityService service;

    public SecondActivityController(SecondActivityService service) {
        this.service = service;
    }

    public void announce(View view) {
        this.service.speak(view);
    }
}

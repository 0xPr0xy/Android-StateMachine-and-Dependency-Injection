package com.example.peterijlst.architecture.two;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by peter.ijlst on 30/03/2018.
 */

public class SecondActivityService {

    public SecondActivityService() {}

    public void speak(View view) {
        Snackbar
                .make(view, "SecondActivityService, sir!", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show();
    }
}

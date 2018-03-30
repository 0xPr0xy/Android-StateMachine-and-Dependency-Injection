package com.example.peterijlst.architecture.three;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by peter.ijlst on 30/03/2018.
 */

public class FourthActivityService {
    public FourthActivityService() {}

    public void speak(View view) {
        Snackbar
                .make(view, "FourthActivity, sir!", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show();
    }
}

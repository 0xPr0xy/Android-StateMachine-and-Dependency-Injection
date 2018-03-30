package com.example.peterijlst.architecture.statemachine;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;

import de.halfbit.tinymachine.StateHandler;
import de.halfbit.tinymachine.TinyMachine;

/**
 * Created by peter.ijlst on 30/03/2018.
 */

interface Injector {
    void inject(Activity activity);
}

interface Router {
    void route(Context context);
    void route(Activity from);
}

public class StateMachine {

    private static final int STATE_MAIN = -1;
    private static final int STATE_TWO = 0;
    private static final int STATE_THREE = 1;

    private SparseArray<Injector> activityInjectors;
    private SparseArray<Router> activityRouters;

    private TinyMachine machine;
    private Context context;

    public StateMachine(Context context) {
        this.context = context;

        machine = new TinyMachine(new TinyHandler(this), STATE_MAIN);

        activityInjectors = new SparseArray<>();
        activityInjectors.put(STATE_TWO, new StateTwoInjector());
        activityInjectors.put(STATE_THREE, new StateThreeInjector());

        activityRouters = new SparseArray<>();
        activityRouters.put(STATE_TWO, new StateTwoRouter());
        activityRouters.put(STATE_THREE, new StateThreeRouter());
    }

    /**
     * initialize the first state handled by the state machine
     * @param current the initial launch activity
     */
    public void initialState(Activity current) {
        machine.transitionTo(STATE_TWO);
        current.finish();
    }

    /**
     * Go to the previous state
     */
    public void previousState() {
        if (machine.getCurrentState() == STATE_THREE) {
            machine.transitionTo(STATE_TWO);
        }
    }

    /**
     * Go to the next state
     */
    public void nextState() {
        if (machine.getCurrentState() == STATE_TWO) {
            machine.transitionTo(STATE_THREE);
        }
    }

    /**
     * Route to the next activity
     * @param from
     */
    public void nextActivity(Activity from) {
        if (from != null) {
            activityRouters.get(machine.getCurrentState()).route(from);
        } else {
            activityRouters.get(machine.getCurrentState()).route(context);
        }
    }

    /**
     * Handle a newly started activity, Inject it's dependencies
     * @param activity
     */
    public void activityStarted(Activity activity) {
        activityInjectors.get(machine.getCurrentState()).inject(activity);

    }

    // STATE HANDLER

    public static class TinyHandler {
        private StateMachine parent;

        TinyHandler(StateMachine parent) {
            this.parent = parent;
        }

        @StateHandler(state = STATE_TWO, type = StateHandler.Type.OnEntry)
        public void onEntryStateTwo() {
            // route to the initial activity for the state
            parent.nextActivity(null);
        }

        @StateHandler(state = STATE_THREE, type = StateHandler.Type.OnEntry)
        public void onEntryStateThree() {
            // route to the initial activity for the state
            parent.nextActivity(null);
        }
    }
}

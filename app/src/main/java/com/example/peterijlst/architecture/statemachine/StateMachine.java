package com.example.peterijlst.architecture.statemachine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.peterijlst.architecture.statemachine.containers.DaggerStateThreeComponent;
import com.example.peterijlst.architecture.statemachine.containers.DaggerStateTwoComponent;
import com.example.peterijlst.architecture.statemachine.containers.StateThreeComponent;
import com.example.peterijlst.architecture.statemachine.containers.StateThreeContainer;
import com.example.peterijlst.architecture.statemachine.containers.StateTwoComponent;
import com.example.peterijlst.architecture.statemachine.containers.StateTwoContainer;
import com.example.peterijlst.architecture.two.SecondActivity;
import com.example.peterijlst.architecture.three.ThirdActivity;

import de.halfbit.tinymachine.StateHandler;
import de.halfbit.tinymachine.TinyMachine;

/**
 * Created by peter.ijlst on 30/03/2018.
 */

public class StateMachine {

    private static final int STATE_MAIN = 0;
    private static final int STATE_TWO = 1;
    private static final int STATE_THREE = 2;

    private TinyMachine machine;

    public StateMachine(Context context) {
        machine = new TinyMachine(new TinyHandler(context), STATE_MAIN);
    }

    public void initialState(Activity current) {
        machine.transitionTo(STATE_TWO);
        current.finish();
    }

    public void previous() {
        if (machine.getCurrentState() == STATE_THREE) {
            machine.transitionTo(STATE_TWO);
        }
    }

    public void next() {
        if (machine.getCurrentState() == STATE_TWO) {
            machine.transitionTo(STATE_THREE);
        }
    }

    public void activityStarted(Activity activity) {
        if (machine.getCurrentState() == STATE_THREE) {
            StateThreeComponent component = DaggerStateThreeComponent
                    .builder()
                    .stateThreeContainer(new StateThreeContainer())
                    .build();
            if (activity instanceof ThirdActivity) {
                component.inject((ThirdActivity) activity);
            }
        } else if (machine.getCurrentState() == STATE_TWO) {
            StateTwoComponent component = DaggerStateTwoComponent
                    .builder()
                    .stateTwoContainer(new StateTwoContainer())
                    .build();
            if (activity instanceof SecondActivity) {
                component.inject((SecondActivity) activity);
            }
        }

    }

    // STATE HANDLER

    public static class TinyHandler {
        private Context context;

        TinyHandler(Context context) {
            this.context = context;
        }

        @StateHandler(state = STATE_TWO, type = StateHandler.Type.OnEntry)
        public void onEntryStateTwo() {
            Intent initialIntent = new Intent(context, SecondActivity.class);
            context.startActivity(initialIntent);
        }

        @StateHandler(state = STATE_THREE, type = StateHandler.Type.OnEntry)
        public void onEntryStateThree() {
            Intent initialIntent = new Intent(context, ThirdActivity.class);
            context.startActivity(initialIntent);
        }
    }
}

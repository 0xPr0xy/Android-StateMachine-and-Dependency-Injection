# Android-StateMachine-and-Dependency-Injection
Example Android App architecture with a StateMachine featuring Dependency Injection and Routers per state
Uses Dagger2 and TinyMachine for DI and state management

## StateMachine
The statemachine is used to transition between states, and launch the initial activity for that state.
It also has a method `nextActivity(Activity from)` that is used either from a launched activity when it is done, or from a state machine transition passing `null` to launch that state's the initial activity
This results in Activities being unaware of other activities, and small states with their own routing and dependency container.

## Injector
The injector is used for a certain state's dependency container (Dagger2 Component per state), to inject the activities dependencies.

```
interface Injector {
    void inject(Activity activity);
}
```
## Router
The router is used for a certain state to determine what activity to launch from another activity.
Or, in case that it is a transition to a new state, launch the initial activity.

```
interface Router {
    void route(Context context);
    void route(Activity from);
}
```


## Application
Since the application registers for activity lifecycle callbacks, and then passes the activity to the current state's dependency injector, the activities don't have to ask for injection. This is done automatically.

```
public class MyApplication extends Application implements Application.ActivityLifecycleCallbacks {

    public StateMachine stateMachine;

    @Override
    public void onCreate() {
        super.onCreate();
        stateMachine = new StateMachine(this);
        registerActivityLifecycleCallbacks(this);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity instanceof MainActivity) {
            this.stateMachine.initialState(activity);
        } else {
            this.stateMachine.activityStarted(activity);
        }
    }
}
```

## Activity
All you need to do in an activity is declare your dependencies as usual for Dagger
```
@Inject
protected Dependency dep;
```
To transition to the next activity, you call the statemachine, and it will figure out what activity needs to be launched
```
((MyApplication) getApplication()).stateMachine.nextActivity(this);
```
To go to a previous or next state
```
((MyApplication) getApplication()).stateMachine.previousState();
((MyApplication) getApplication()).stateMachine.nextState();
```

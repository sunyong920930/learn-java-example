package lean.java.example.thread.AwaitNotify;

/**
 * Created by sunyong on 2018-08-31.
 */
public class PushTarget implements Runnable {

    private ConditionTest conditionTest;

    public PushTarget(ConditionTest conditionTest) {
        this.conditionTest = conditionTest;
    }

    @Override
    public void run() {
        conditionTest.push();
    }
}

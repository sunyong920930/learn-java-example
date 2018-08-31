package lean.java.example.thread.AwaitNotify;

/**
 * Created by sunyong on 2018-08-31.
 */
public class TakeTarget implements Runnable {

    private ConditionTest conditionTest;

    public TakeTarget(ConditionTest conditionTest) {

        this.conditionTest = conditionTest;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        conditionTest.take();
    }
}

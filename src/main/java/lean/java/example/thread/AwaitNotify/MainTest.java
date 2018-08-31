package lean.java.example.thread.AwaitNotify;

/**
 * Created by sunyong on 2018-08-31.
 */
public class MainTest {

    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();

        PushTarget pushTarget = new PushTarget(conditionTest);
        TakeTarget takeTarget = new TakeTarget(conditionTest);

        for (int i = 0; i < 20; i++) {
            new Thread(pushTarget).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 20; i++) {
            new Thread(takeTarget).start();
        }
    }
}

package lean.java.example.design.patterns.delegate;

/**
 * Created by sunyong on 2018-09-06.
 */
public class ExectorA implements IExector {
    @Override
    public void doing() {
        System.out.println("A");
    }
}

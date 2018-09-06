package lean.java.example.design.mode.delegate;

/**
 * Created by sunyong on 2018-09-06.
 */
public class Disruptor {

    private IExector exector;

    public Disruptor(IExector exector) {
        this.exector = exector;
    }

    //项目经理，虽然也有执行方法
    //但是他的工作职责是不一样的
    public void doing() {
        this.exector.doing();
    }
}

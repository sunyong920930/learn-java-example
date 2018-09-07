package lean.java.example.design.patterns.delegate;

/**
 * Created by sunyong on 2018-09-06.
 */
public class Disruptor implements IExector {

    private IExector exector;

    public Disruptor(IExector exector) {
        this.exector = exector;
    }

    //项目经理，虽然也有执行方法
    //但是他的工作职责是不一样的
    //委派模式，只在乎结果，不在乎过程
    @Override
    public void doing() {
        this.exector.doing();
    }
}

package lean.java.example.design.patterns.delegate;

/**
 * Created by sunyong on 2018-09-06.
 * 委派模式
 * 特点:
 * 1.类似中介的功能（委托模式）
 * 2.持有被委托人的引用
 * 3. 不关心过程，只关心结果，而代理模式关心的是过程
 */
public class DisruptorTest {

    public static void main(String[] args) {
        //看上去好像是我们的项目经理在干活
        //但实际干活的人是普通员工
        //这就是典型，干活是我的，功劳是你的
        Disruptor disruptor = new Disruptor(new ExectorA());
        disruptor.doing();
    }
}

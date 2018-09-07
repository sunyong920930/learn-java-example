package lean.java.example.design.patterns.template;

/**
 * Created by sunyong on 2018-09-07.
 */
public class Coffee extends Bevegrage {

    @Override
    protected void addCoundiments() {
        System.out.println("添加coffee作料");
    }

    @Override
    protected void pourInCup() {
        System.out.println("添加coffee");
    }
}

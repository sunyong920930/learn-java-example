package lean.java.example.design.patterns.template;

/**
 * Created by sunyong on 2018-09-07.
 */
public abstract class Bevegrage {

    public final void createBevegrage() {
        //1.烧水
        boiltWater();
        //2、把杯子准备好、原材料放到杯中
        pourInCup();
        //3、用水冲泡
        brew();
        //4、添加辅料
        addCoundiments();
    }

    private void brew() {
        System.out.println("用水冲泡");
    }

    protected abstract void addCoundiments();

    // 非公共部分，让子类自己实现
    protected abstract void pourInCup();

    protected void boiltWater(){
        //公共的部分
        System.out.println("烧水");
    }

}

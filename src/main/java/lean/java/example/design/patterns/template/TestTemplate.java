package lean.java.example.design.patterns.template;

/**
 * Created by sunyong on 2018-09-07.
 */
public class TestTemplate {

    public static void main(String[] args){
        Coffee coffee = new Coffee();
        coffee.createBevegrage();
        System.out.println("=================================");
        Tea tea = new Tea();
        tea.createBevegrage();
    }

}

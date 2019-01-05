package lean.java.example.basic.basic4;

/**
 * Created by sunyong on 2019/1/5.
 */
public class Test extends Father{

    private String name = "test";

    public static void main(String[] args){
        Test test = new Test();
        System.out.println(test.getName());
    }
}

class Father{
    private String name = "father";

    public String getName(){
        return name;
    }
}

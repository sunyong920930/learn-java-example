package lean.java.example.reflect.reflect8;

/**
 * Created by sunyong on 2018-09-14.
 */
public class StudentController {

    @Autowired("name")
    public String name;

    @Autowired("i")
    private Integer i;
}

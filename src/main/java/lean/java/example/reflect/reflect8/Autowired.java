package lean.java.example.reflect.reflect8;

import java.lang.annotation.*;

/**
 * Created by sunyong on 2018-09-14.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Autowired {

    String value() default "";
}

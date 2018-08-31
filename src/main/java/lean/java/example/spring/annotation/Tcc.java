package lean.java.example.spring.annotation;

import java.lang.annotation.*;

/**
 * Created by sunyong on 2018-08-28.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Tcc {

    String value() default "";
}

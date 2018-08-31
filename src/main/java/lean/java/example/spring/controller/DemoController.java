package lean.java.example.spring.controller;

import lean.java.example.spring.annotation.Desc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sunyong on 2018-05-30.
 * 测试类
 */
@Controller
public class DemoController {

    @Desc("注解")
    //@AroudAuthority(methodName = "getDemo") // 添加@AroudAuthority注解 可以增强代码
    @RequestMapping("/demo")
    @ResponseBody
    public String getDemo() {
        return "123";
    }
}

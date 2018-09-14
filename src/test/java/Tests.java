import lean.java.example.UserDaoImpl;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by sunyong on 2018-09-08.
 */
public class Tests {

    @Test
    public void main1() {
        // 根据xml配置文件创建Resource资源文件，该对象中包含了BeanDefinition的信息
        ClassPathResource resource = new ClassPathResource("");
        // 创建DefaultListableBeanFactory对象
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        // 创建XmlBeanDefinitionReader读取器，用于载入BeanDefinition，之所以需要BeanFactory作为参数，是因为读取的信息回调配置给factory
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        // XmlBeanDefinitionReader执行载入BeanDefinition的方法，最后会完成Bean的载入和注册，完成后Bean就成功的放置到IOC容器中，以后我们就可以从中取得bean来使用
        reader.loadBeanDefinitions(resource);
    }

}

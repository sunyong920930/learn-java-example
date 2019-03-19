
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by sunyong on 2018-09-08.
 */
public class Tests {

//    @Test
//    public void main1() {
//        // 根据xml配置文件创建Resource资源文件，该对象中包含了BeanDefinition的信息
//        ClassPathResource resource = new ClassPathResource("");
//        // 创建DefaultListableBeanFactory对象
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        // 创建XmlBeanDefinitionReader读取器，用于载入BeanDefinition，之所以需要BeanFactory作为参数，是因为读取的信息回调配置给factory
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        // XmlBeanDefinitionReader执行载入BeanDefinition的方法，最后会完成Bean的载入和注册，完成后Bean就成功的放置到IOC容器中，以后我们就可以从中取得bean来使用
//        reader.loadBeanDefinitions(resource);
//    }

    private static String addZero(int param) {
        String paramStr= param<10 ? "0"+param : "" + param ;
        return paramStr;
    }

    public static String getMil2ssTimeFormat(String timeStr) {
        long time = Long.parseLong(timeStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        String monthStr = addZero(month);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String dayStr = addZero(day);
        //24小时制
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String hourStr = addZero(hour);
        int minute = calendar.get(Calendar.MINUTE);
        String minuteStr = addZero(minute);
        int second = calendar.get(Calendar.SECOND);
        String secondStr = addZero(second);
        return (year + "-" + monthStr + "-" + dayStr + " " + hourStr + ":" + minuteStr + ":" + secondStr);
    }

}

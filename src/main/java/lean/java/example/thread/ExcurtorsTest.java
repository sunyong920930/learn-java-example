package lean.java.example.thread;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunyong on 2018-08-31.
 */
public class ExcurtorsTest {

    private static DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    private static DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    private static ScheduledExecutorService excutor = Executors.newScheduledThreadPool(1);

    private String getDate() {
        String format = sdf.format(new Date());
        return format;
    }

    public static void main(String[] args) {

        ExcurtorsTest t = new ExcurtorsTest();
        excutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : " + t.getDate() + " : " + "123");
            }
        }, 0, 200, TimeUnit.MILLISECONDS);
    }

    /**
     * 按指定频率周期执行某个任务 <br>
     * 初始化延迟0ms开始执行，每隔5ms重新执行一次任务。
     */
    public void fixedRate() {
        excutor.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }, //执行线程
                0,  //初始化延迟
                5000, //两次开始的执行的最小时间间隔
                TimeUnit.MILLISECONDS //计时单位
        );
    }

    /**
     *
     */
    public void fixDelay() {
        excutor.scheduleWithFixedDelay(
                new Runnable() {
                    @Override
                    public void run() {

                    }
                },//执行线程
                0, //初始化延迟
                5000, //前一次执行结束到下一次执行开始的间隔时间
                TimeUnit.MILLISECONDS);
    }

    /**
     * 每天晚上8点执行一次
     */
    public void dayOfDelay(String time) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        long oneDay = 24 * 60 * 60 * 1000;
        long initDelay = getTimeMillis("16:20:00") - System.currentTimeMillis();
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;
        executor.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        try {//必须加try-catch防止方法里面异常后下次定时任务不执行
                            System.out.println(1234);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                initDelay,
                oneDay,
                TimeUnit.MILLISECONDS);
    }

    /**
     * 获取给定时间对应的毫秒数
     *
     * @param "HH:mm:ss"
     * @return
     */
    private static long getTimeMillis(String time) {
        try {
            Date currentDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
            return currentDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

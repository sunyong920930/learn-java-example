synchronized 可以锁重入----底层是monitorentor进入同步方法  monitorexit退出
可以作用在三种地方：
1、作用在实例方法上 public synchronized void a(){} 锁是实例对象锁
2、作用在静态方法上 public static synchronized void increase(){} 锁是当前类的class对象
3、作用在同步代码块上 synchronized(instance){} 锁指定加锁对象，对给定对象加锁
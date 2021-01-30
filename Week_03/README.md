### 学习笔记
一、通用的线程生命周期

1. 初始状态：线程已经被创建，但是还不允许分配CPU执行。
2. 可运行状态：线程可以分配CPU执行
3. 运行状态：被分配到CPU的线程状态
4. 休眠状态：运行状态的线程如果调用一个阻塞的API或者等待某个事件
5. 终止状态：线程执行完或者出现异常
------------------------------------------------------------------------------
二、Java中线程的生命周期
1. NEW（初始化状态）
2. RUNNABLE（可运行/运行状态）
3. BLOCKED（阻塞状态）
4. WAITING（无限时等待）
5. TIMED_WAITING（有限时等待）
6. TERMINATED（终止状态）
* Java线程处于BLOCKED、WAITING、TIMED_WAITING状态，就永远没有CPU的使用权
-------------------------------------------------------------------------
RUNNABLE与BLOCKED的状态转换
1. 等待synchronized的隐式锁
2. RUNNABLE与WAITING的状态转换
    - 获得synchronized隐式锁的线程，调用无参数的Object.wait()方法。
    - 调用无参数的Thread.join()方法。其他线程调用join()方法时，当前线程会进入WAITING状态。
    - 调用LockSupport.park()方法。
3. RUNNABLE与TIMED_WAITING的状态转换
    - 调用带超时参数的 Thread.sleep(long millis) 方法；
    - 获得 synchronized 隐式锁的线程，调用带超时参数的 Object.wait(long timeout) 方法；
    - 调用带超时参数的 Thread.join(long millis) 方法；
    - 调用带超时参数的 LockSupport.parkNanos(Object blocker, long deadline) 方法；
    - 调用带超时参数的 LockSupport.parkUntil(long deadline) 方法。
4. 从NEW到RUNNABLE状态
    - 调用线程对象的start()方法
--------------------
    MyThread myThread = new MyThread();
    // 从 NEW 状态转换到 RUNNABLE 状态
    myThread.start()；

* 当线程 A 处于 WAITING、TIMED_WAITING 状态时，如果其他线程调用线程 A 的 interrupt() 方法，会使线程 A 返回到 RUNNABLE 状态，同时线程 A 的代码会触发 InterruptedException 异常。

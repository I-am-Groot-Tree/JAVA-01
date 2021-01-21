# 学习笔记             
### GC日志分析：

    Parallel GC
    java -Xmx4g -XX:+UseParallelGC GCLogAnalysis
    16717
    java -Xmx2g -XX:+UseParallelGC GCLogAnalysis
    15347
    java -Xmx1g -XX:+UseParallelGC GCLogAnalysis
    14288
    java -Xmx1g -Xms1g -XX:+UseParallelGC GCLogAnalysis
    16231
    java -Xmx512M -XX:+UseParallelGC GCLogAnalysis
    9850

* 总结：
  1. 堆内存的大小太小不好，太大也不好，要根据压测的实际情况调整，一般建议在不影响性能的情况下堆内存尽量的小，gc效率最大化
  2. 堆太小并且年轻代生成对象的速率过快，会先导致频繁的young gc,然后随着时间推移年轻代的对象慢慢回收不掉，老年代也放不下就会频繁触发full GC，最后雪崩效应导致OOM服务挂掉
  3. 堆太大会导致每次young gc要回收的对象过多，造成的STW时间过长，吞吐量也并不高
-----------------------------------------------------------------------------------------
### GC压测分析：
    Serial GC
    java -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+UseSerialGC GCLogAnalysis
    10次 young gc 0.042-0.056
    1次 full gc	  0.047
    11979
    
    Parallel GC
    java -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+UseParallelGC GCLogAnalysis
    26次 young gc 0.006-0.014
    2次 full gc	  0.045
    14730
    
    CMS GC
    java -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC GCLogAnalysis
    12次 young gc 0.01-0.04
    2次 full gc	  0.047（CMS-concurrent-abortable-preclean）
    13559
    
    G1 GC
    java -Xmx1g -Xms1g -XX:+PrintGC -XX:+UseG1GC GCLogAnalysis
    12次 young gc 0.01
    1次 full gc	  0.02
    14013

* 总结：
1. Serial GC 
    * 优点：简单高效，适合单核CPU
    * 缺点：STW时间太长。
2. Parallel GC
    * 优点：吞吐量比较高
    * 缺点：STW时间太长。
3. CMS GC
    * 优点：并发收集、STW较短
    * 缺点：产生大量空间碎片、并发阶段会降低吞吐量
4. G1 GC
    * 优点：
    1. 空间整合，G1收集器采用标记整理算法，不会产生内存空间碎片，分配大对象时不会因为无法找到连续空间而提前触发下一次GC。
    2. 可预测停顿
-----------------------------------------------------------------------------------------------
### Socket压测分析：
    sb -u http://localhost:8801 -c 40 -N 30
    1、单线程
    RPS: 1 (requests/second)
    Max: 68ms
    Min: 68ms
    Avg: 68ms
    
    2、每个请求新建一个线程
    RPS: 801 (requests/second)
    Max: 204ms
    Min: 0ms
    Avg: 9.9ms
    
    3、固定线程池处理请求(4+2个线程)
    RPS: 929.1 (requests/second)
    Max: 148ms
    Min: 0ms
    Avg: 6.4ms
    
    4、Netty 
    sb -u http://localhost:8808/test -c 10 -N 30
    
    RPS: 1822.9 (requests/second)
    Max: 76ms
    Min: 0ms
    Avg: 1.1ms
* 总结：虽然线程池能有效的复用线程处理请求，但和Netty的高性能、高吞吐量相比远远不如。
package io.kimmking.kmq.core;

import lombok.SneakyThrows;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class Kmq {
    private String topic;

    private int capacity;

    private QueueArray<KmqMessage> queue;

    public Kmq(String topic, int capacity) {
        this.topic = topic;
        this.capacity = capacity;
        this.queue = new QueueArray(capacity);
    }

    public boolean send(KmqMessage message) {
        queue.enQueue(message);
        return true;
    }

    public KmqMessage poll() {
        return queue.deQueue();
    }

}

package io.kimmking.kmq.core;

/**
 * @ClassName QueueArray
 * @description
 */
public class QueueArray<T> {


    private int capacity;
    private T[] elements;
    private int front;
    private int rear;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
        front = 0;
        rear = 0;
    }

    public int getSize() {
        return (rear - front + capacity) % capacity;
    }

    public boolean isEmpty() {
        return (front == rear) ? true : false;
    }

    public boolean isFull() {
        return ((rear + 1) % capacity == front) ? true : false;
    }


    //扩容
    private void expandSpace() {
        Object[] a = new Object[elements.length * 2];
        int i = front;
        int j = 0;

        while (i != rear) {
            a[j++] = elements[i];
            i = (i + 1) % capacity;
        }
        elements = (T[]) a;
        capacity = elements.length;
        //设置新的队首队尾指针
        front = 0;
        rear = j;
    }

    public void enQueue(Object e) {
        if ((rear + 1) % capacity == front) {
            expandSpace();
        }
        elements[rear] = (T) e;
        rear = (rear + 1) % capacity;

    }


    public T deQueue() {
        if (rear == front) {
            return null;
        } else {
            T o = elements[front];
            front = (front + 1) % capacity;
            return o;
        }

    }


    public Object getFront() {
        if (rear == front) {
            System.out.println("queue is empty");
        }
        return elements[front];
    }

    @Override
    public String toString(){
        if(isEmpty()){
            return "[]";
        }else{
            StringBuilder sb = new StringBuilder("[");
            for(int i = front;i < rear;i++){
                sb.append(elements[i].toString()+",");
            }
            return sb.toString().substring(0,sb.length()-1)+"]";
        }

    }


    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(4);

        for (int i = 0; i < 4; i++) {
            queueArray.enQueue(i);
        }
        System.out.println("循环队列：" + queueArray);
        System.out.println(queueArray.deQueue() + "出队");
        System.out.println("4入队");
        queueArray.enQueue(4);
        System.out.println("循环队列：" + queueArray);

    }


}

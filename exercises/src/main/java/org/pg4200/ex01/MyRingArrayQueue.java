package org.pg4200.ex01;

import org.pg4200.les02.queue.MyQueue;

public class MyRingArrayQueue<T> implements MyQueue<T> {

    Object[] data;

    public MyRingArrayQueue(){
        this(10);
    }

    public MyRingArrayQueue(int maxSize){
        data = new Object[maxSize];
    }



    private int head = -1;
    private int tail= -1;

    @Override
    public void enqueue(T value) {



        if(isEmpty()) {
            head = 0;
            tail = 0;
        }
        else if (head <= tail) {
            if(tail < data.length-1){

                tail++;
        }
            else {
                if(head!=0){
                    tail = 0;
                }
                else {
                    Object[] tmp = new Object[(data.length*2)];

                    for(int i = 0; i < data.length; i++){
                        tmp[i] = data[i];
                    }

                    data = tmp;
                    tail++;
                }
            }
        }
        else {
            assert tail == head;

            if (head -1 > tail) {
                tail++;
            }
            else {
                /*
                    array is totally full. but making copy is not trivial,
                    as we need to make sure to re-align such that head=0 && head < tail
                 */
                Object[] tmp = new Object[(data.length * 2)];

                int k = data.length - head;
                for(int i=0; i<k; i++){
                    tmp[i] = data[head + i];
                }

                for(int i=0; i< (tail+1); i++){
                    tmp[k + i] = data[i];
                }

                head = 0;
                tail = data.length;
                data = tmp;
            }
        }
        data[tail] = value;
    }

    @Override
    public T dequeue() {
        T value = (T)data[head];

        if(size() == 1) {
            head = -1;
            tail = -1;
        }

        else{
            head++;
            if(head >= data.length){
                head = 0;
            }

        }
        return (T) value;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw  new RuntimeException();
        }
        return (T) data[head];
    }

    @Override
    public int size() {

        if(head < 0) {
            return 0;
        }
        else if(head == tail) {
            return 1;
        }
        else if (head < tail) {
            return tail - head;
        }
        else {
            int size = 0;

            size += data.length + head;
            size += tail + 1;

            return size;
        }
    }
}

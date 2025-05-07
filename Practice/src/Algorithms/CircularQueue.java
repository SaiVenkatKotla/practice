package Algorithms;

public class CircularQueue {

    private int[] queue;
    private int rear, front, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.rear = -1;
        this.front = 0;
        this.size = 0;
        queue = new int[this.capacity];
    }

    private boolean isFull() {
        return size == capacity;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is already full");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = x;
        size++;
        System.out.println("Enqueued:" + x);
    }

    private int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return  -1;
        }
        int x = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Dequeued:"+ x);
        return x;
    }

    private void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Queue contents");
        for(int i=0;i<size ;i++){
            System.out.println(queue[(front + i) % capacity] + " ");
        }

        System.out.println();
    }

    private int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front % capacity];
    }


    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(10);
        cq.enqueue(10);
        cq.enqueue(3);
        cq.enqueue(4);
        cq.enqueue(5);
        cq.enqueue(1);
        cq.display();
        System.out.println(cq.dequeue());
        System.out.println(cq.dequeue());
    }
}

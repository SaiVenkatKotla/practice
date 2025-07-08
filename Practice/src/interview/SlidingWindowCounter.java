package interview;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class  SlidingWindowCounter{

/*
    HashMap<Long, Node> eventMap;

    private final Node  temp = new Node(0);
    */
    Node head;
    Node tail;
    public SlidingWindowCounter(){
/*
        eventMap =  new HashMap<>();
*/
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public void addEvent(long timestamp) {
/*
        eventMap.put(timestamp, temp);
*/
        Node newNode = new Node(timestamp);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
    }

    /*
    if n are the no of event in entre double LL
    ws - O(n)
    as - O(n/2)
    bs - O(1)
     */
    public int getCount(long currentTime) {
        /*eventMap.entrySet().stream().filter(entry -> (entry.getKey() <= currentTime && entry.getKey() >= currentTime - 300))
                .count();*/
        int count = 0;
        Node nextHead = head.next;
        while(nextHead != null && nextHead.value <= currentTime && nextHead.value  >= currentTime - 300){
            count++;
            nextHead = nextHead.next;
        }
        if( nextHead != null && nextHead.value < currentTime - 300){
            nextHead.prev.next = tail;
            tail.prev = nextHead.prev;
        }
        return count;
    }

    public static void main(String[] args) {
        SlidingWindowCounter slc = new SlidingWindowCounter();
        slc.addEvent(1000);
        slc.addEvent(1100);
        slc.addEvent(1200);

        int count = slc.getCount(1300);  // Returns 3
        System.out.println(count);

        count = slc.getCount(1400);
        System.out.println(count);

        slc.addEvent(1450);
        slc.addEvent(1500);

        count = slc.getCount(1500);  // Returns 3
        System.out.println(count);


    }

}

class Node{
    long value;
    Node prev;
    Node next;

    public Node(long v){
        this.value = v;
        this.next =null;
        this.prev = null;
    }
}
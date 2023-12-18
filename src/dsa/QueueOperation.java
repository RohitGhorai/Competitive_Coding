package dsa;

import java.util.*;

public class QueueOperation {
    public static void main(String[] args) {
        Queue<Integer> qu = new LinkedList<>();

        //Add elements in queue
        qu.add(30);
        qu.add(40);
        qu.add(50);
        qu.add(60);

        //Remove the front element from queue
        qu.remove();

        //Display the front element of queue
        int front = qu.peek();
        System.out.println("Front element is " + front);

        //Search the element from queue
        int target = 50;
        int index = search(qu, target);
        System.out.println(target + " present in \"" + index + "\" index");

        System.out.println(Arrays.toString(qu.toArray()));
    }
    static int search(Queue<Integer> qu, int target){
        int index = 0;
        int[] arr = new int[qu.toArray().length];
        Iterator<Integer> iterator = qu.iterator();
        while(iterator.hasNext()){
            for(int i = 0; i < qu.toArray().length; i++){
                arr[i] = iterator.next();
            }
        }
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == target) index = i;
        }
        return index;
    }
}

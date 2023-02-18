package interview;

import java.util.PriorityQueue;
import java.util.Queue;

class Nodes {
    public int val;
    public Nodes left;
    public Nodes right;
    public Nodes next;

    public Nodes() {}

    public Nodes(int _val) {
        val = _val;
    }

    public Nodes(int _val, Nodes _left, Nodes _right, Nodes _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class UpdateRightPointers {
    public static void main(String[] args) {
        Nodes root = new Nodes();

        CreatePointers(root);
    }

    private static void CreatePointers(Nodes root) {
        Queue<Nodes> queue = new PriorityQueue<>() {};
        queue.add(root);
        int i = 0;
        while(!queue.isEmpty()){
            int numberToPop = (int) Math.pow(2.0,i);
            createLinks(queue);
            for(int k = 0 ; k < numberToPop ; k++){
                Nodes node = queue.poll();
                queue.add(node.left);
                queue.add(node.right);
            }

        }
    }

    private static void createLinks(Queue<Nodes> queue) {
        Queue copyQueue = queue;
        int size = queue.size();
        for(int i =0 ; i < size ;i++){
            Nodes first = (Nodes) copyQueue.poll();
            Nodes second = (Nodes) copyQueue.peek();

            first.next = second;

        }
    }
}

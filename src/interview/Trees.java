package interview;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class Trees {
    public static void main(String[] args) {
        Node root;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(9);

        //HashMap<String,Integer> hashMap = new HashMap<>();
        //hashMap.put("abc", hashMap.getOrDefault("abc",0)+1);
        /*
                     1
                 2        3
              4    5    6    7
                                 9

         */

        //printInorder(root);

        //parseTree(root,0);
        int height = calculateHeightOfTree(root);
        //System.out.println(" the height of the tree is " + height);

        printNodesAtDistance(root,2);
        //printPositionOfNode(root,0);
        //printPositionOfNodeHorizontal(root,0,0);

    }

    private static void printInorder(Node root) {
        if(root == null){
            return;
        }
        System.out.println("the node and it s value is "  + root.data);
        printInorder(root.left);
        printInorder(root.right);

    }

    private static void printPositionOfNodeHorizontal(Node root,int currPosition,int level) {
        if(root == null){
            return;
        }
        System.out.println("The root position is  " +  currPosition + "  and the level which is on "  + level);
        printPositionOfNodeHorizontal(root.left,currPosition-1,level + 1);
        printPositionOfNodeHorizontal(root.right,currPosition+1,level+1);

    }

    private static void printPositionOfNode(Node root, int position) {

    }

    private static void printNodesAtDistance(Node root, int distance) {

        HashMap<Node,Node> childToParentMap = new HashMap<>();
        childToParentMap.put(root,null);
        Queue<Node> pq= new ArrayDeque<>();
        pq.add(root);

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(node.left != null){
                pq.add(node.left);
                childToParentMap.put(node.left,node);
            }
            if(node.right != null){
                pq.add(node.right);
                childToParentMap.put(node.right,node);
            }
        }

        iterateNodesBelow(root,6,3,childToParentMap, new ArrayList<Node>());

    }

    private static void iterateNodesBelow(Node root, int target, int distance, HashMap<Node, Node> childToParentMap, ArrayList<Node> visited) {
        if(root == null){
            return;
        }
        if(root.data == target){
            printDownFromThis(root,distance,null);
            while(distance > 0 && !visited.contains(root)){
                distance -= 1;
                visited.add(root);
                printDownFromThis(childToParentMap.get(root),distance,root);
                root = childToParentMap.get(root);

            }
            return;
        }
        iterateNodesBelow(root.left,target,distance,childToParentMap,visited);
        iterateNodesBelow(root.right,target,distance,childToParentMap,visited);

    }

    private static void printDownFromThis(Node root, int distance,Node visited) {
        if(root == visited){
            return;
        }
        if(root == null){
            return;
        }
        if(distance ==0){
            System.out.println("the node with given distance is " + root.data);
            return;
        }
        printDownFromThis(root.left,distance-1,visited);
        printDownFromThis(root.right,distance-1,visited);

    }

    private static int calculateHeightOfTree(Node root) {
        if(root == null) {
            return 0;
        }
        else{
            return 1 + Math.max(calculateHeightOfTree(root.left),calculateHeightOfTree(root.right));
        }
    }

    private static void parseTree(Node root,int level) {
        if(root == null){
            return;
        }else{
            System.out.println("the value of the root is " + root.data + "  and the level located is " +  level);
            parseTree(root.left,level+1);
            parseTree(root.right,level+1);
        }
    }
}

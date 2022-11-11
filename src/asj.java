//public class Node {
//    int data;
//    Node left;
//    Node right;
//
//    public Node(int data){
//        this.data = data;
//        this.left = null;
//        this.right = null;
//    }
//}
//
//public class Main{
//
//    public void printBoundary(Node node){
//
//        if(node!=null){
//            System.out.println(node.data + " ");
//
//            printBoundaryLeft(node.left);
//            printLeaves(node.left);
//            printLeaves(node.right);
//
//            printBoundaryRight(node.right);
//        }
//    }
//
//    public void printBoundaryLeft(Node node){
//
//        if(node == null) {
//            return;
//        }
//
//        if(node.left != null){
//            System.out.print(node.data + " ");
//            printBoundaryLeft(node.left);
//
//        }else if(node.right != null) {
//            System.out.print(node.data +" ");
//            printBoundaryLeft(node.right);
//        }
//    }
//
//    public void printLeaves(Node node){
//        if(node == null) {
//            return;
//
//        }
//        if(node.left == null && node.right == null){
//            System.out.print(node.data + " ");
//        }
//
//    }
//    public void printBoundaryRight(Node node){
//        if(node == null){
//            return;
//
//        }
//
//        if(node.right != null){
//            printBoundaryRight(node.right);
//            System.out.print(node.data + " ");
//        } else if(node.left!=null){
//            printBoundaryRight(node.left);
//            System.out.print(node.data+" ");
//
//        }
//    }
//
//    public Node createNewNode(int val){
//        Node newNode = new Node();
//        newNode.data = val;
//        newNode.left = null;
//        return newBNode;
//
//    }
//}
//public class Trees {
//    public static void main(String[] args) {
//
//        BinaryTree a = new BinaryTree();
//        Node root = a.createNewNode(1);
//        root.left = a.createNewNode(2);
//        root.right = a.createNewNode(3);
//        root.left.left =a.createNewNode(4);
//        root.left.right = a.createNewNode(5);
//        root.right.left = a.createNewNode(6);
//        root.right.right = a.createNewNode(7);
//        root.right.right.right = a.createNewNode(8);
//
//        a.printBoundary(root);
//
//
//    }
//}

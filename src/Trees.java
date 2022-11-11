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
        /*
                     1
                 2          3
              4    5     6    7
            11 12         9

         */

        printInorder(root);

        //parseTree(root,0);
        //int height = calculateHeightOfTree(root);
       // System.out.println(" the height of the tree is " + height);

        //printNodesAtDistance(root,0,2);
        //printPositionOfNode(root,0);
       // printPositionOfNodeHorizontal(root,0,0);

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

    private static void printNodesAtDistance(Node root, int current ,int desired) {
        if(root == null){
            return;
        }
        if( current == desired){
            System.out.println("The root at n levev from the top " + root.data);
        }
        printNodesAtDistance(root.left,current+1,desired);
        printNodesAtDistance(root.right,current+1,desired);

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

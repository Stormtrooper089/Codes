package interview;

import java.util.*;

class GraphNode{
    int vertex;
    int destination;

    boolean visited;

    public GraphNode(int vertex){
        this.vertex = vertex;
        this.visited = false;
    }
}
public class GraphDfs {



    public static void main(String [] args){
        int flights[][] = {{0,1},{0,4},{0,8},{0,5},{1,2},{2,3},{8,6},{6,7}};

        HashMap<Integer, ArrayList<GraphNode>> adjacencyList = new HashMap<>();

        for (int [] flight:
             flights) {
            if(!adjacencyList.containsKey(flight[0])){
                adjacencyList.put(flight[0],new ArrayList<>());
            }
            adjacencyList.get(flight[0]).add(new GraphNode(flight[1]));
        }


        // print bfs the graph  from vertex 0
        GraphNode start = new GraphNode(0);
        start.visited = true;
        Stack<GraphNode> pq = new Stack<>();
        pq.add(start);
        System.out.println("the node is  " +  start.vertex);



        while(!pq.isEmpty()){
            GraphNode node = pq.peek();
            if(!node.visited){
                System.out.println("the node is  " +  node.vertex);
            }
            List<GraphNode> graphNodeList = adjacencyList.get(node.vertex);
            if(graphNodeList == null){
                pq.pop();
            }else{
                Optional<GraphNode> newNode = graphNodeList.stream()
                        .filter(n -> !n.visited )
                        .findFirst();
                if (!newNode.isEmpty()){
                    adjacencyList.get(node.vertex).remove(newNode.get());
                    newNode.get().visited = true;
                    System.out.println("the node is  " +  newNode.get().vertex);

                    adjacencyList.get(node.vertex).add(newNode.get());
                    pq.add(newNode.get());
                }else{
                    pq.pop();
                }
            }
        }
    }
}

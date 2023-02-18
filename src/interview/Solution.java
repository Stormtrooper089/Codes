package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Edge{
    public int dest;
    public boolean color;
    public boolean visited;

    Edge(int dest, boolean color){
        this.dest=dest;
        this.color=color;
        this.visited=false;
    }
}

class Element {

    public Edge edge;
    public int level;
    Element(Edge edge, int level){
        this.edge=edge;
        this.level=level;
    }
}

class Solution {
    public static void main(String[] args) {
        int n = 3 ;
        int [][] redEdges ={{0,1},{1,2}};
        int [][] blueEdges ={};
        shortestAlternatingPaths(n,redEdges,blueEdges);
    }

    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        ArrayList<Edge>[] graph=new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<Edge>();
        }

        for(int i=0;i<redEdges.length;i++){
            graph[redEdges[i][0]].add(new Edge(redEdges[i][1],false));
        }

        for(int i=0;i<blueEdges.length;i++){
            graph[blueEdges[i][0]].add(new Edge(blueEdges[i][1],true));
        }

        Queue<Element> q=new LinkedList<Element>();

        int [] res=new int[n];

        boolean [] visited =new boolean[n];

        for(int i=0;i<n;i++){
            res[i]=-1;
        }



        q.offer(new Element(new Edge(0,true),0));

        while(!q.isEmpty()){
            Element elt=q.peek();
            q.poll();
            Edge edge=elt.edge;
            int dest=edge.dest;
            boolean color=edge.color;
            int level=elt.level;
            if(res[dest]==-1)
                res[dest]=level;

            if(edge.visited) continue;
            edge.visited =true;

            for(int i=0;i<graph[dest].size();i++){
                Edge newEdge=graph[dest].get(i);
                if(dest == 0){
                    q.offer(new Element(newEdge,level+1));
                    continue;
                }
                if(newEdge.color != color){
                    q.offer(new Element(newEdge,level+1));
                }
            }
        }
        return res;
    }
}
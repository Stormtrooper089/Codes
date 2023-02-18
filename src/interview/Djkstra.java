package interview;

import java.util.*;

public class Djkstra {

    class Flight {
        int src;
        int dst;
        int price;

        Flight (int src, int dst, int price) {
            this.src = src;
            this.dst = dst;
            this.price = price;
        }
    }

    class Stop {
        int id, cost, count;
        Stop(int id, int cost, int count) {
            this.id = id;
            this.cost = cost;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        /*
        n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
        src = 0, dst = 2, k = 1
         */
        int n = 3;
        int src = 0;
        int dest = 2;
        int k = 1;
        int flights[][] = {{0,1,100},{1,2,100},{0,2,500}};
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

    HashMap<Integer,ArrayList<Flight>> map = new HashMap<>();
    for(int[] flight :flights){
        if(!map.containsKey(flight[0])){
            map.put(flight[0],new ArrayList<Flight>());
        }
        map.get(flight[0]).add(new Flight(flight[0],flight[1],flight[2]));
    }

        Comparator<Stop> cmp = new Comparator<Stop>() {
            public int compare(Stop s1, Stop s2) {
                return s1.cost - s2.cost;
            }
        };
        PriorityQueue<Stop> q = new PriorityQueue<Stop>(cmp);

        q.offer(new Stop(src, 0, K));
        while (q != null && !q.isEmpty()) {
            Stop cur = q.poll();
            if (cur.id == dst) {
                return cur.cost;
            }

            if (cur.count >= 0) {
                List<Flight> list = map.get(cur.id);
                if (list == null) {
                    continue;
                }
                for (Flight f: list) {
                    q.offer(new Stop(f.dst, f.price + cur.cost, cur.count - 1));
                }
            }
        }

        return -1;
    }

}
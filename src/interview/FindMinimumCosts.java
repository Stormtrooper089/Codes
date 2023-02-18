package interview;

public class FindMinimumCosts {
    public static void main(String[] args) {
        int [] days = {1,4,6,7,8,20};
        int[] costs =  {2,7,15};
        int cost = findTheCOsts(0,0,days.length,days,costs);
    }

    private static int findTheCOsts(int index,int currPos, int length, int[] days, int[] costs) {
        if(index >= length){
            return 0;
        }
        if(currPos <= days[index]){

        }
        return Math.min(costs[0]+findTheCOsts(index+1,currPos+costs[0],length,days,costs),costs[1]+findTheCOsts(index+1,currPos+costs[1],length,days,costs));
    }
}

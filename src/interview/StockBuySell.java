package interview;

public class StockBuySell {
    public static void main(String[] args) {
        int [] nums = {7,1,5,3,6,4};
        findTheMaxProfit(nums);
    }

    private static void findTheMaxProfit(int[] nums) {
        int profit = 0;
        int lastbuy = -1;
        int lastSold = -1;
        int diff = 0;
        for(int i =1; i < nums.length ; i++){
            if(nums[i] > nums[i-1]){
                diff = nums[i] - nums[i-1];
                profit = profit + diff;
            }
        }
        System.out.println("print the profit " + profit);
    }
}

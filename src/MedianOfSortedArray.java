public class MedianOfSortedArray {
    public static void main(String[] args) {
        int [] nums1 = {1,3};
        int [] nums2 = {2};

        findTheMedian(nums1,nums2);
    }

    private static void findTheMedian(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int r1 = 0;
        int r2 = 0;
        int a = 0;
        int b = 0;
        double n =l1+l2;

        for(int i=0;i<(n/2);i++){

            int first=0;
            if(a>=l1){
                first = Integer.MAX_VALUE;
            }else{
                first = Math.min(nums1[a],Integer.MAX_VALUE);
            }

            int second = 0;
            if(b>=l2){
                second = Integer.MAX_VALUE;
            }else{
                second = Math.min(nums2[b],Integer.MAX_VALUE);
            }

            r1=r2;
            r2 = Math.min(first,second);
            System.out.println("the value of r1 "  + r1 +  "  the value of r2 is " + r2 +  "  and the value of n " + n);
            if(first < second){
                a++;
            }else{
                b++;
            }
        }


        if(n%2==0){
            System.out.println((r1+r2)/2.0);
        }else{
            System.out.println(r2);
        }

    }
}

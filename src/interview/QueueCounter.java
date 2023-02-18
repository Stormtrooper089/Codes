package interview;

public class QueueCounter {
    public static void main(String[] args) {
        int [] q1= {20,25,10,40};
        int q2[] = {10,15,30};

        findTheSequence(q1,q2,q1.length,0,q2.length,0);
    }

    private static void findTheSequence(int[] q1, int[] q2, int lengthI, int i, int lengthJ, int j) {
        if(i < lengthI && j<lengthJ){
            if(q1[i] < q2[j]){
                System.out.print(q1[i]+" ");
                i++;
            }else{
                System.out.print(q2[j]+" ");
                j++;
            }
        }
        if( i == lengthI){
            while(j<lengthJ){
                System.out.print(q2[j] +" ");
                j++;
            }
            return;
        }
        if( j == lengthJ){
            while(i<lengthI){
                System.out.print(q1[i]+" ");
                i++;
            }
            return;
        }


        findTheSequence(q1,q2,lengthI,i,lengthJ,j);
    }
}

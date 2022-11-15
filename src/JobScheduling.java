import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Activity{
    int start;
    int end;
    int profit;
    public Activity(int start, int end,int profit){
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

public class JobScheduling {
    public static void main(String[] args) {
        int [] start = {1,2,3,3};
        int [] end = {3,4,5,6};
        int [] cost = {50,10,40,70};

        ArrayList<Activity> arrayList = new ArrayList<>();


        for (int i =0 ; i < start.length ;i++){
            Activity activity = new Activity(start[i],end[i],cost[i]);
            arrayList.add(activity);
        }

        Collections.sort(arrayList, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.start-o2.start;
            }
        });
        int max[] = new int[start.length];

        takeJob(arrayList, max, 0, 0, start.length);

    }


    static int takeJob(ArrayList<Activity> jobs, int[] max, int i, int t, int n) {
        // Iterate until we run out of jobs or have a job we can take
        while (i < n && t > jobs.get(i).start)
            ++i;

        if (i == n)
            return 0;

        if (max[i] != 0)
            return max[i];
        // Re-use previously calculated max profit from this job onward

        int take = jobs.get(i).profit + takeJob(jobs, max, i+1, jobs.get(i).end, n);
        int skip = takeJob(jobs, max, i+1, t, n);

        max[i] = Math.max(take, skip);
        return max[i];
    }
}


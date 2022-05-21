import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class activity_selection {
    
    static class Job{
        public final int start;     
        public final int finish;    
 
    
    private Job(int start, int finish){
        this.start = start;
        this.finish = finish;
    }
 

    public static Job of(int a, int b){
        
        return new Job(a, b);
    }
}

    public static int findNonConflictingJobsLength(List<Job> jobs){
       
        Collections.sort(jobs, Comparator.comparingInt(job -> job.start));
 
     
        int[] L = new int[jobs.size()];
 
        for (int i = 0; i < jobs.size(); i++){
            
            for (int j = 0; j < i; j++){               
                if (jobs.get(j).finish < jobs.get(i).start && L[i] < L[j]) {
                    L[i] = L[j];
                }
            }
 
            L[i]++;
        }
 
        
        return Arrays.stream(L).max().getAsInt();
    }
 
    public static void main(String[] args){
        List<Job> jobs = Arrays.asList(
                Job.of(1, 4), Job.of(3, 5), Job.of(0, 6),
                Job.of(5, 7), Job.of(3, 8), Job.of(5, 9),
                Job.of(6, 10), Job.of(8, 11), Job.of(8, 12),
                Job.of(2, 13), Job.of(12, 14)
        );
 
        System.out.println("The maximum number of non-conflicting jobs is "
                + findNonConflictingJobsLength(jobs));
    }

    
}
    
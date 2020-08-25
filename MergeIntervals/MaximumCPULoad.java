package MergeIntervals;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumCPULoad {
    public static int findMaxCPULoad(List<Job> jobs) {
        if(jobs == null || jobs.size() == 0){

        };
        PriorityQueue<Meeting> priorityJobs = 
            new PriorityQueue<>(jobs.size(), (a, b) -> Integer.compare(a.end, b.end));

        for(Job job : jobs){
            while(!priorityJobs.isEmpty() && job.start >= priorityJobs.peek().start){
                priorityJobs.poll();
            };
        };

        return -1;
    };
};
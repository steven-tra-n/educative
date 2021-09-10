package MergeIntervals;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumCPULoad {
    public static int findMaxCPULoad(List<Job> jobs) {
        if(jobs == null || jobs.size() == 0){
            return -1;
        };

        Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start)); // Sort jobs by start time
        
        int maxLoad = 0;
        int currentLoad = 0;
        PriorityQueue<Job> priorityJobs = 
            new PriorityQueue<>(jobs.size(), (a, b) -> Integer.compare(a.end, b.end));

        for(Job job : jobs){
            while(!priorityJobs.isEmpty() && job.start >= priorityJobs.peek().end){ // Remove jobs that have ended
                currentLoad -= priorityJobs.poll().cpuLoad;
            };

            priorityJobs.offer(job);
            currentLoad += job.cpuLoad;
            maxLoad = Math.max(maxLoad, currentLoad);
        };

        return maxLoad;
    };

    public static int findMaxCPULoad2(List<Job> jobs) {
        int maxLoad = 0;
        int currentLoad = 0;

        if(jobs == null || jobs.size() == 0){
            return -1;
        };

        Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Job> priorityJobs = new PriorityQueue<>(jobs.size(), (a, b) -> Integer.compare(a.end, b.end));

        for(int i = 0; i < jobs.size(); i++){
            while(!priorityJobs.isEmpty() && jobs.get(i).start >= priorityJobs.peek().end){
                currentLoad -= priorityJobs.poll().cpuLoad;
            };

            priorityJobs.add(jobs.get(i));
            currentLoad += jobs.get(i).cpuLoad;
            maxLoad = Integer.max(maxLoad, currentLoad);
        };

        return maxLoad;
    };
};

// List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
// System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

// input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
// System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

// input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
// System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
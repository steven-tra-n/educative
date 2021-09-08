package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConflictingAppointments {
    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i - 1].end){ // Can still attend appointment if start <= end
                return false;
            };
        };
        
        return true;
    };

    public static boolean canAttendAllAppointments2(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start <= intervals[i - 1].end){ // Only conflicts if i starts before i - 1 ends
                return false;
            };
        };

        return true;
    };  

    public static boolean findAllConflictingAppointments(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        List<Interval> result = new ArrayList<>();

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i - 1].end){
                result.add(new Interval(intervals[i - 1].start, intervals[i - 1].end));
                result.add(new Interval(intervals[i].start, intervals[i].end));
            };
        };

        return true;
    };  
};

// Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
//     boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
//     System.out.println("Can attend all appointments: " + result);

//     Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
//     result = ConflictingAppointments.canAttendAllAppointments(intervals1);
//     System.out.println("Can attend all appointments: " + result);

//     Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
//     result = ConflictingAppointments.canAttendAllAppointments(intervals2);
//     System.out.println("Can attend all appointments: " + result);
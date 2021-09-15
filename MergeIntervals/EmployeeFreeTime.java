package MergeIntervals;

import java.util.List;
import java.util.*;

public class EmployeeFreeTime {
    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
      List<Interval> employeeTimes = new ArrayList<>();
      List<Interval> result = new ArrayList<>();

      for(List<Interval> intervalList : schedule) { // Add intervals into single list so we can sort
        for (Interval interval : intervalList) {
            employeeTimes.add(interval);
        };
      };

      Collections.sort(employeeTimes, (a, b) -> Integer.compare(a.start, b.start));

      for(int i = 1; i < employeeTimes.size(); i++){ // Find slots where start time is greater than end time
        if(employeeTimes.get(i).start > employeeTimes.get(i - 1).end){
          result.add(new Interval(employeeTimes.get(i - 1).end, employeeTimes.get(i).start));
        };
      };

      return result;
    };
};

// List<List<Interval>> input = new ArrayList<>();
//     input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
//     input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
//     List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
//     System.out.print("Free intervals: ");
//     for (Interval interval : result)
//       System.out.print("[" + interval.start + ", " + interval.end + "] ");
//     System.out.println();

//     input = new ArrayList<>();
//     input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
//     input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
//     input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
//     result = EmployeeFreeTime.findEmployeeFreeTime(input);
//     System.out.print("Free intervals: ");
//     for (Interval interval : result)
//       System.out.print("[" + interval.start + ", " + interval.end + "] ");
//     System.out.println();

//     input = new ArrayList<>();
//     input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
//     input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
//     input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
//     result = EmployeeFreeTime.findEmployeeFreeTime(input);
//     System.out.print("Free intervals: ");
//     for (Interval interval : result)
//       System.out.print("[" + interval.start + ", " + interval.end + "] ");
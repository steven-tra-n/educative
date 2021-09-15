package MergeIntervals;

import java.util.List;
import java.util.*;

public class EmployeeFreeTime {
    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
      List<Interval> employeeTimes = new ArrayList<>();
      List<Interval> result = new ArrayList<>();

      for(List<Interval> intervalList : schedule) {
        for (Interval interval : intervalList) {
            employeeTimes.add(interval);
        };
      };

      Collections.sort(employeeTimes, (a, b) -> Integer.compare(a.start, b.start));

      for(int i = 1; i < employeeTimes.size(); i++){
        if(employeeTimes.get(i).start > employeeTimes.get(i - 1).end){
          result.add(new Interval(employeeTimes.get(i - 1).end, employeeTimes.get(i).start));
        };
      };

      return result;
    };
};

// [1,3], [2,3], [5,6], [6,8]
// [1,3], [2,4], [6,8], [9,12]
// [1,3], [2,4], [3,5], [7,9]

// Find slots where start time is greater than end time
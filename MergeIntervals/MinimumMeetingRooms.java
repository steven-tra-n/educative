package MergeIntervals;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {
    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        int rooms = 1;

        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

        for(int i = 1; i < meetings.size(); i++){
            if(meetings.get(i).start < meetings.get(i - 1).end){
                rooms++;
                i = i + 2; // One room per two appointments
            };
        };

        return rooms;
    };

    public static int findMinimumMeetingRooms1(List<Meeting> meetings) {
        if (meetings == null || meetings.size() == 0)
        return 0;

        // sort the meetings by start time
        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

        int minRooms = 0;
        PriorityQueue<Meeting> minHeap = 
            new PriorityQueue<>(meetings.size(), (a, b) -> Integer.compare(a.end, b.end));
        for (Meeting meeting : meetings) {
        // remove all meetings that have ended
        while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end)
            minHeap.poll();
        // add the current meeting into the minHeap
        minHeap.offer(meeting);
        // all active meeting are in the minHeap, so we need rooms for all of them.
        minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    };
};

// List<Meeting> input = new ArrayList<Meeting>() {
//     {
//         add(new Meeting(2, 3));
//         add(new Meeting(2, 4));
//         add(new Meeting(3, 5));
//         add(new Meeting(4, 5));
//     }
//   };
//   int result = MinimumMeetingRooms.findMinimumMeetingRooms1(input);
//   System.out.println("Minimum meeting rooms required: " + result);

//   input = new ArrayList<Meeting>() {
//     {
//       add(new Meeting(1, 4));
//       add(new Meeting(2, 5));
//       add(new Meeting(7, 9));
//     }
//   };
//   result = MinimumMeetingRooms.findMinimumMeetingRooms1(input);
//   System.out.println("Minimum meeting rooms required: " + result);

//   input = new ArrayList<Meeting>() {
//     {
//       add(new Meeting(6, 7));
//       add(new Meeting(2, 4));
//       add(new Meeting(8, 12));
//     }
//   };
//   result = MinimumMeetingRooms.findMinimumMeetingRooms1(input);
//   System.out.println("Minimum meeting rooms required: " + result);

//   input = new ArrayList<Meeting>() {
//     {
//       add(new Meeting(1, 4));
//       add(new Meeting(2, 3));
//       add(new Meeting(3, 6));
//     }
//   };
//   result = MinimumMeetingRooms.findMinimumMeetingRooms1(input);
//   System.out.println("Minimum meeting rooms required: " + result);

//   input = new ArrayList<Meeting>() {
//     {
//       add(new Meeting(4, 5));
//       add(new Meeting(2, 3));
//       add(new Meeting(2, 4));
//       add(new Meeting(3, 5));
//     }
//   };
//   result = MinimumMeetingRooms.findMinimumMeetingRooms1(input);
//   System.out.println("Minimum meeting rooms required: " + result);
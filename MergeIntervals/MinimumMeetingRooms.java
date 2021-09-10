package MergeIntervals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

    public static int findMinimumMeetingRooms2(List<Meeting> meetings) { // Does not work. Needs to be priority queue
        if(meetings == null || meetings.size() == 0){
            return 0;
        };

        // Sort by start time
        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

        int minRooms = 0;
        Queue<Meeting> meetingQueue = new LinkedList<>();

        for(Meeting meeting : meetings){
            while(!meetingQueue.isEmpty() && meeting.start >= meetingQueue.peek().end){ // Remove meeting that ends same time current meeting started
                meetingQueue.poll();
            };

            meetingQueue.add(meeting);

            minRooms = Math.max(minRooms, meetingQueue.size());
        };

        return minRooms;
    };

    public static int findMinimumMeetingRooms3(List<Meeting> meetings) {
        if(meetings == null || meetings.size() == 1){
            return 0;
        };

        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

        int roomCount = 1; // Start with one room

        for(int i = 1; i < meetings.size(); i ++){
            if(meetings.get(i).start < meetings.get(i - 1).end){ // Meeting clash, need another room
                roomCount++;
                i = i + 2; // Only one room per two meetings
            };
        };

        return roomCount;
    };

    public static int findMinimumMeetingRooms4(List<Meeting> meetings) {
        int roomsNeeded = 0;

        if(meetings == null || meetings.size() == 1){
            return roomsNeeded;
        };

        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));
        
        PriorityQueue<Meeting> minHeap = new PriorityQueue<>(meetings.size(), (a, b) -> Integer.compare(a.end, b.end));


        for(int i = 0; i < meetings.size(); i++){
            // Keep adding meetings into priority queue. If we find an iteration that has a start time later than the smallest end time, they can use the same room
            while(!minHeap.isEmpty() && meetings.get(i).start >= minHeap.peek().end){ 
                minHeap.remove();
            };

            minHeap.add(meetings.get(i));

            roomsNeeded = Math.max(roomsNeeded, minHeap.size());
        };

        return roomsNeeded;
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
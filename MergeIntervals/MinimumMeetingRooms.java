package MergeIntervals;

import java.util.Collections;
import java.util.List;

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
};
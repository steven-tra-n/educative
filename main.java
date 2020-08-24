import java.util.ArrayList;
import java.util.List;

import MergeIntervals.*;

public class main {
    public static void main(String[] args){
        List<Meeting> input = new ArrayList<Meeting>() {
    {
        add(new Meeting(2, 3));
        add(new Meeting(2, 4));
        add(new Meeting(3, 5));
        add(new Meeting(4, 5));
    }
  };
  int result = MinimumMeetingRooms.findMinimumMeetingRooms2(input);
  System.out.println("Minimum meeting rooms required: " + result);

  input = new ArrayList<Meeting>() {
    {
      add(new Meeting(1, 4));
      add(new Meeting(2, 5));
      add(new Meeting(7, 9));
    }
  };
  result = MinimumMeetingRooms.findMinimumMeetingRooms2(input);
  System.out.println("Minimum meeting rooms required: " + result);

  input = new ArrayList<Meeting>() {
    {
      add(new Meeting(6, 7));
      add(new Meeting(2, 4));
      add(new Meeting(8, 12));
    }
  };
  result = MinimumMeetingRooms.findMinimumMeetingRooms2(input);
  System.out.println("Minimum meeting rooms required: " + result);

  input = new ArrayList<Meeting>() {
    {
      add(new Meeting(1, 4));
      add(new Meeting(2, 3));
      add(new Meeting(3, 6));
    }
  };
  result = MinimumMeetingRooms.findMinimumMeetingRooms2(input);
  System.out.println("Minimum meeting rooms required: " + result);

  input = new ArrayList<Meeting>() {
    {
      add(new Meeting(4, 5));
      add(new Meeting(2, 3));
      add(new Meeting(2, 4));
      add(new Meeting(3, 5));
    }
  };
  result = MinimumMeetingRooms.findMinimumMeetingRooms2(input);
  System.out.println("Minimum meeting rooms required: " + result);
    };
};
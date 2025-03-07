package geeksforgeeks;

import java.util.*;

public class MeetingScheduler {

    /**
     * Method to calculate the maximum number of meetings that can be accommodated in a single meeting room.
     *
     * @param start Array of start times of meetings.
     * @param end   Array of end times of meetings.
     * @return Maximum number of meetings that can be held.
     */
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        if (n == 0) {
            return 0;
        }

        // Create a list of meetings with their start and end times
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }

        // Sort meetings by end time
        meetings.sort(Comparator.comparingInt(a -> a.end));

        int count = 1; // At least one meeting can be held
        int lastEnd = meetings.getFirst().end;

        // Iterate through the sorted meetings and select non-overlapping ones
        for (int i = 1; i < n; i++) {
            if (meetings.get(i).start > lastEnd) {
                count++;
                lastEnd = meetings.get(i).end;
            }
        }

        return count;
    }

    // Helper class to represent a meeting
    private static class Meeting {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        MeetingScheduler scheduler = new MeetingScheduler();

        // Example 1
        int[] start1 = {1, 3, 0, 5, 8, 5};
        int[] end1 = {2, 4, 6, 7, 9, 9};
        System.out.println(scheduler.maxMeetings(start1, end1)); // Expected output: 4

        // Example 2
        int[] start2 = {10, 12, 20};
        int[] end2 = {20, 25, 30};
        System.out.println(scheduler.maxMeetings(start2, end2)); // Expected output: 1

        // Example 3
        int[] start3 = {1, 2};
        int[] end3 = {100, 99};
        System.out.println(scheduler.maxMeetings(start3, end3)); // Expected output: 1
    }
}
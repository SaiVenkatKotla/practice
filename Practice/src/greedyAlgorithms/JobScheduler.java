package greedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JobScheduler {


    public static void main(String[] args) {
        ArrayList<Job> jobs = new ArrayList<>();

        jobs.add(new Job('A', 2, 100));
        jobs.add(new Job('B', 1, 19));
        jobs.add(new Job('C', 2, 27));
        jobs.add(new Job('D', 1, 25));
        jobs.add(new Job('E', 3, 15));

        scheduler(jobs);
    }

    static void scheduler(ArrayList<Job> jobs) {
        int n = jobs.size();

        boolean[] slots = new boolean[n];
        char[] result = new char[n];

        jobs.sort((a, b) -> b.profit - a.profit);

        for (Job job : jobs) {
            for (int j = Math.min(n, job.deadline) - 1; j >= 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    result[j] = job.id;
                    break;
                }
            }
        }

        IntStream.range(0, n).filter(i -> slots[i]).forEach(i -> System.out.println(result[i]));
    }
}


class Job {
    char id;
    int deadline, profit;

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
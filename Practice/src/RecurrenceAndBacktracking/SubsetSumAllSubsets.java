package RecurrenceAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumAllSubsets {

    public static void main(String[] args) {
        int[] nums = {3, 34, 4, 12, 5, 2};
        int target = 9;

        List<List<Integer>> allSubsets = new ArrayList<>();
        findSubsets(nums, 0, target, new ArrayList<>(), allSubsets);

        System.out.println("Subsets that sum to " + target + ":");
        for (List<Integer> subset : allSubsets) {
            System.out.println(subset);
        }
    }

    public static void findSubsets(int[] nums, int index, int target,
                                   List<Integer> current, List<List<Integer>> allSubsets) {
        // Base case: target achieved
        if (target == 0) {
            allSubsets.add(new ArrayList<>(current)); // Add a copy of the current subset
            return;
        }

        // Base case: end of array or target becomes negative
        if (index >= nums.length || target < 0) {
            return;
        }

        // Include the current number
        current.add(nums[index]);
        findSubsets(nums, index + 1, target - nums[index], current, allSubsets);

        // Backtrack: remove the number and try excluding it
        current.remove(current.size() - 1);
        findSubsets(nums, index + 1, target, current, allSubsets);
    }
}


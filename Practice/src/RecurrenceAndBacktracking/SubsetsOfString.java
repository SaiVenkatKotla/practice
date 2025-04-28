package RecurrenceAndBacktracking;

public class SubsetsOfString {
    static void generateSubsets(String str, String ans, int index) {
        if (index == str.length()) {
            System.out.println(ans);
            return;
        }
        generateSubsets(str, ans + str.charAt(index), index + 1); // choose
        generateSubsets(str, ans, index + 1); // don't choose
    }

    public static void main(String[] args) {
        generateSubsets("abc", "", 0);
    }
}

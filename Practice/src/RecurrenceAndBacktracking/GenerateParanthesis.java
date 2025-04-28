package RecurrenceAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public static void main(String[] args) {
        int n  = 4;
        List<String> generatedParanthesis = new ArrayList<>();
        generate("", 0, generatedParanthesis, n);
        generatedParanthesis.forEach(System.out::println);
    }

    private static void generate(String str, int p , List<String> generatedParanthesis, int n) {
        if (str.length() == n * 2 && p == 0) {
            generatedParanthesis.add(str);
        } else if (str.length() > n * 2 || p < 0)
            return;

        generate(str + "(", p + 1, generatedParanthesis, n);
        if(p > 0) {
            generate(str + ")", p - 1, generatedParanthesis, n);
        }

    }
}

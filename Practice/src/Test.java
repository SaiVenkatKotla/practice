import java.util.*;

public class Test {

    public static void main(String[] args) {
       String s = "cabwefgewcwaefgcf";
       String t ="cae";
       int left = 0 , right;
       String result = s + t;
       char[] targetChars = t.toCharArray();
       Arrays.sort(targetChars);
       for(right = t.length(); right<= s.length(); right++){
           char[] sourcedChar = s.substring(left, right).toCharArray();
           Arrays.sort(sourcedChar);
           if(findMatching(sourcedChar, targetChars)){
               if( result.length() > right - left){
               result = s.substring(left, right);
               }
               left++;
               right = left + t.length() -1;
           }
       }
        System.out.println(result.equals(s + t) ? "" : result);

    }

    private static boolean findMatching(char[] sourcedChar , char[] targetChars){
        int[] sourceFreq = new int[58];

        for(char c : sourcedChar){
            sourceFreq[c-'A']++;
        }

        for(char c: targetChars){
            sourceFreq[c-'A']--;
            if(sourceFreq[c-'A'] < 0)
                return false;
        }

        return true;
    }


}

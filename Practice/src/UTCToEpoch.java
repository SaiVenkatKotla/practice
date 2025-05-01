import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UTCToEpoch {
    public static void main(String[] args) {
        String day = "Tue Apr 29 03:00:31 EDT 2025";
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

        // Parse the date string into a Date object
        Date date = null;
        try {
            date = sdf.parse(day);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // Get epoch milliseconds
        long epochMillis = date.getTime();
        System.out.println(String.valueOf(epochMillis));
    }
}

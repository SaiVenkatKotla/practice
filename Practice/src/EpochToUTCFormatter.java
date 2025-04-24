import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class EpochToUTCFormatter {
    public static void main(String[] args) {
        long epochTime = 1745319039; // epoch time in seconds

        // Convert to Instant
        Instant instant = Instant.ofEpochMilli(epochTime);

        // Convert to ZonedDateTime in UTC
        ZonedDateTime utcDateTime = instant.atZone(ZoneId.of("UTC"));

        // Format to "MM/dd/yyyy HH:mm:ss z"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss z");

        String formattedUTC = utcDateTime.format(formatter);
        System.out.println("Formatted UTC time: " + formattedUTC);
    }
}



package utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class UtcToEtConverter {
    public static void main(String[] args) {
        String utcDateTimeStr = "2025-05-24T00:00:00";  // UTC = ET + 4h
        LocalDateTime localDateTime = LocalDateTime.parse(utcDateTimeStr);

        // Define UTC and ET zones
        ZonedDateTime utcZoned = localDateTime.atZone(ZoneId.of("UTC"));
        ZonedDateTime etZoned = utcZoned.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime cetZoned = utcZoned.withZoneSameInstant(ZoneId.of("Europe/Paris"));

        // Format with abbreviation like EDT or EST
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        String formattedEt = etZoned.format(formatter);

        System.out.println("Eastern Time: " + formattedEt);
        System.out.println("U Time: " + utcZoned);
        System.out.println("cetZoned Time: " + cetZoned);

    }
}

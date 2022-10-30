package com.observationclass.ultis;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Utils {
    public static Timestamp resultTimestamp() {
        // HoanNNC update common remove time zone
        LocalDateTime localDateTimeWithoutTimeZone = Instant.now().atOffset(ZoneOffset.UTC).toLocalDateTime();
        return Timestamp.valueOf(localDateTimeWithoutTimeZone);
    }

}

package com.app.api.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Anish Panthi
 */
public class DateUtil {

    public static String getLocalDateNow() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return localDate.format(formatter);
    }
}

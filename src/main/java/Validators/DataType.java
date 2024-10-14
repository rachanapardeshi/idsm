package Validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public enum DataType {
    INTEGER,
    STRING,
    BOOLEAN,
    DATE,
    ENUM;

    public static final int MIN_YEAR = 0;
    public static final int MAX_YEAR = 9999;

    @Override
    public String toString() {
        return super.toString().toUpperCase();
    }

    /**
     * Parses a date: yyyy-mm-dd where 0 < yyyy < 9999
     */
    public static boolean isValidDate(String dateString) {
        try {
            LocalDate d = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
            return (d.getYear() >= MIN_YEAR || d.getYear() <= MAX_YEAR);
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}

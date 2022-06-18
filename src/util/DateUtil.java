package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    public static LocalDate getString2LocalDateTime(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return LocalDate.parse(dateStr, formatter);
    }


    public static int getAge(String str) {
        LocalDate today = LocalDate.now();
        LocalDate birth = getString2LocalDateTime(str);
        int age = today.getYear() - birth.getYear() + 1; //한국식 나이
        LocalDate localDate = today.withYear(birth.getYear());
        // 오늘 날짜가 생일 이전인가
        if (localDate.isAfter(birth)) {
            //맞다면 -1
            age -= 1;
        } else {
            //아니라면 -2
            age -= 2;
        }
        return age;
    }

    public static String getToday() {
        return getToday("yyyy-MM-dd HH:mm:ss");
    }


    public static String getToday(String format) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }

}

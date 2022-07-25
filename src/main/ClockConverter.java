package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClockConverter {

    private final String[] oneDigit = {"","one","two", "three","four","five","six","seven","eight","nine"};
    private final String[] tenPlus = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen"};
    private final String[] twoDigit = {"twenty", "thirty", "forty", "fifty"};
    public String convert(String time) {
        if (time == null || time.trim().length() == 0) {
            return "Please provide a time to convert";
        }
        if (time.equals("12:00")) {
            return "It's midday";
        }
        if (time.equals("00:00")) {
            return "It's midnight";
        }
        Pattern pattern = Pattern.compile("(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$");
        Matcher matcher = pattern.matcher(time.trim());
        if (!matcher.find()){
            return "Time format is invalid, please enter hh:mm";
        }

        String[] timeArr = time.trim().split(":");
        StringBuilder timeStringBuilder = new StringBuilder("It's ");
        int hour = Integer.parseInt(timeArr[0]);
        convertNumber(timeStringBuilder, hour);
        int minute = Integer.parseInt(timeArr[1]);
        convertNumber(timeStringBuilder, minute);
        return timeStringBuilder.toString().trim();
    }
    private void convertNumber(StringBuilder timeStringBuilder, int number) {
        if (number < 10 ) {
            timeStringBuilder.append(oneDigit[number]).append(" ");
        }else if (number < 20) {
            timeStringBuilder.append(tenPlus[number-10]).append(" ");
        }else {
            timeStringBuilder.append(twoDigit[(number/10)-2]).append(" ").append(oneDigit[number%10]).append(" ");
        }
    }
}

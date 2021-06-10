package br.com.vbdev.beleza_agendada.util;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.ReadableInstant;

public class ConvertHour {

    public static DateTime convertToHour(String hour) {

        LocalTime time = new LocalTime(hour);

        ReadableInstant instant = new DateTime();

        DateTime date = time.toDateTime(instant)/**.minusHours(3)*/;

//        System.out.println(date.getHourOfDay() + ":" + date.getMinuteOfHour());

        return date;
    }

}

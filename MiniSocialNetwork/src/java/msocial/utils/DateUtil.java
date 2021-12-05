/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msocial.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author phamduchieu
 */
public class DateUtil {

    private DateFormat dateFormat = new SimpleDateFormat("EEE dd/MM/yyyy");
    private DateFormat hourFormat = new SimpleDateFormat("H");
    private DateFormat dateFormatValue = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    
    public String getDateValue(){
        String dateValue = "";
        dateValue = dateFormatValue.format(Calendar.getInstance().getTime());
        return dateValue;
    }
    
    public String getCurrentDayOfWeek() {
        String dayOfWeek = "";
        String value = dateFormat.format(Calendar.getInstance().getTime()).split(" ")[0] + "";
        if (value.equals("Mon")) {
            dayOfWeek = "Monday";
        } else if (value.equals("Tue")) {
            dayOfWeek = "Tuesday";
        } else if (value.equals("Wed")) {
            dayOfWeek = "Wednesday";
        } else if (value.equals("Thu")) {
            dayOfWeek = "Thursday";
        } else if (value.equals("Fri")) {
            dayOfWeek = "Friday";
        } else if (value.equals("Sat")) {
            dayOfWeek = "Saturday";
        } else if (value.equals("Sun")) {
            dayOfWeek = "Sunday";
        }
        return dayOfWeek;
    }

    public String getCurrentDayOfMonth() {
        String dayOfMonth = dateFormat.format(Calendar.getInstance().getTime()).split(" ")[1].split("/")[0] + "";
        return dayOfMonth;
    }

    public String getCurrentMonth() {
        String month = "";
        int value = Integer.parseInt(dateFormat.format(Calendar.getInstance().getTime()).split(" ")[1].split("/")[1]);
        if (value == 1) {
            month = "January";
        } else if (value == 2) {
            month = "February";
        } else if (value == 3) {
            month = "March";
        } else if (value == 4) {
            month = "April";
        } else if (value == 5) {
            month = "May";
        } else if (value == 6) {
            month = "June";
        } else if (value == 7) {
            month = "July";
        } else if (value == 8) {
            month = "August";
        } else if (value == 9) {
            month = "September";
        } else if (value == 10) {
            month = "October";
        } else if (value == 11) {
            month = "November";
        } else if (value == 12) {
            month = "December";
        }
        return month;
    }

    public String getCurrentYear() {
        String year = dateFormat.format(Calendar.getInstance().getTime()).split(" ")[1].split("/")[2];
        return year;
    }

    public int getHourInDayValue() {
        int hour = Integer.parseInt(hourFormat.format(Calendar.getInstance().getTime()));
        return hour;
    }
}

package helpers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DateForCalendar {
    public String day;
    public String month;
    public String year;

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }
}

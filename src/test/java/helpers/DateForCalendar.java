package helpers;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Data
public class DateForCalendar {
    private String day;
    private String month;
    private String year;
}

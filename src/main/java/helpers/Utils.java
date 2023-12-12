package helpers;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import static java.util.Locale.ENGLISH;

public class Utils {

    /**
     * Возвращение рандомного значения из enum типов.
     *
     * @param clazz - enum.
     */
    public <T extends Enum<?>> T getRandomEnumValue(Class<T> clazz) {
        int x = new SecureRandom().nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    /**
     * Метод для получения даты, с разбивкой на число, месяц и год в строковых свойствах объекта.
     *
     * @param date - дата, подвергаемая разложению на составные части
     * @return
     */
    public DateForCalendar getDateForCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        DateForCalendar dateforcalendar = new DateForCalendar();

        dateforcalendar.setMonth(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, ENGLISH));
        dateforcalendar.setYear(String.valueOf(cal.get(Calendar.YEAR)));
        dateforcalendar.setDay(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));

        return dateforcalendar;
    }

    public String getRandomState(){
        String[] states = {"Haryana", "Rajasthan", "Uttar Pradesh", "NCR"};
        return states[new Random().nextInt(states.length)];
    }

    public String getRandomCity(String state) {
        String city = null;
        Faker faker = new Faker();

        String[] cityByNCR = {"Noida", "Gurgaon", "Delhi"};
        String[] cityByUttarPradesh = {"Agra", "Lucknow", "Merrut"};
        String[] cityByRajasthan = {"Jaiselmer", "Jaipur"};
        String[] cityByHaryana = {"Panipat", "Karnal"};

        switch (state){
            case ("NCR"):
                city = cityByNCR[new Random().nextInt(cityByNCR.length)];
                break;
            case ("Uttar Pradesh"):
                city = faker.options().option(cityByUttarPradesh);
                break;
            case ("Rajasthan"):
                city = faker.options().option(cityByRajasthan);
                break;
            case ("Haryana"):
                city = cityByHaryana[new Random().nextInt(cityByHaryana.length)];
                break;
        }
        return city;
    }
}

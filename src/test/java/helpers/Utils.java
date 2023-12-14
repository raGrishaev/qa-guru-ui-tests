package helpers;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomUtils;
import pages.enums.Gender;
import pages.enums.Hobbies;
import pages.enums.Subjects;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import static java.util.Locale.ENGLISH;

public class Utils {

    Faker faker = new Faker(new Locale("en"));

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

        dateforcalendar.month(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, ENGLISH));
        dateforcalendar.year(String.valueOf(cal.get(Calendar.YEAR)));
        dateforcalendar.day(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));

        return dateforcalendar;
    }

    /**
     * Метод для получения локации в строковых свойствах объекта.
     *
     * @return объект c штатом и городом
     */

    public StateAndCity getRandomStateAndCity() {
        StateAndCity location = new StateAndCity();
        String[] states = {"Haryana", "Rajasthan", "Uttar Pradesh", "NCR"};

        location.setState(states[new Random().nextInt(states.length)]);

        String[] cityByNCR = {"Noida", "Gurgaon", "Delhi"};
        String[] cityByUttarPradesh = {"Agra", "Lucknow", "Merrut"};
        String[] cityByRajasthan = {"Jaiselmer", "Jaipur"};
        String[] cityByHaryana = {"Panipat", "Karnal"};

        switch (location.getState()){
            case ("NCR"):
                location.setCity(cityByNCR[new Random().nextInt(cityByNCR.length)]);
                break;
            case ("Uttar Pradesh"):
                location.setCity(faker.options().option(cityByUttarPradesh));
                break;
            case ("Rajasthan"):
                location.setCity(faker.options().option(cityByRajasthan));
                break;
            case ("Haryana"):
                location.setCity(cityByHaryana[new Random().nextInt(cityByHaryana.length)]);
                break;
        }
        return location;
    }

    public RegistrationDataModel generateDataForRegistration(){

        StateAndCity location = getRandomStateAndCity();

        Date date = new Date();
        date.setTime(Instant.now().minus(Duration.ofDays(RandomUtils.nextInt(0, 36500))).toEpochMilli());
        DateForCalendar dateForCalendar = getDateForCalendar(date);

        return new RegistrationDataModel()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .userEmail(faker.internet().emailAddress())
                .gender(getRandomEnumValue(Gender.class).getValue())
                .userNumber(faker.phoneNumber().subscriberNumber(10))
                .subject(getRandomEnumValue(Subjects.class).toString())
                .hobie(getRandomEnumValue(Hobbies.class).toString())
                .currentAddress(faker.chuckNorris().fact())
                .state(location.getState())
                .city(location.getCity())
                .imagePath("img/2023-09-25_11h30_08.png")
                .imageName("2023-09-25_11h30_08.png")
                .day(dateForCalendar.day())
                .month(dateForCalendar.month())
                .year(dateForCalendar.year());
    }

    public TextBoxDataModel generateDataForTextBox(){
        return new TextBoxDataModel()
                .fullName(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .currentAddress(faker.chuckNorris().fact())
                .permanentAddress(faker.chuckNorris().fact());

    }
}

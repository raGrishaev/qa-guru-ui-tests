package helpers;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Data
public class RegistrationDataModel {
    private String firstName;
    private String lastName;
    private String userEmail;
    private String gender;
    private String userNumber;
    private String subject;
    private String hobie;
    private String currentAddress;
    private String state;
    private String city;
    private String year;
    private String month;
    private String day;
    private String imagePath;
    private String imageName;
}

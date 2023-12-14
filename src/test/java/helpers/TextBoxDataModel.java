package helpers;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Data
public class TextBoxDataModel {

    private String fullName;
    private String email;
    private String currentAddress;
    private String permanentAddress;
    private String submit;
    private String outputArea;
}

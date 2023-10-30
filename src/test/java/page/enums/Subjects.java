package page.enums;

public enum Subjects {
    ENGLISH("English"),
    CHEMISTRY("Chemistry"),
    COMMERCE("Commerce"),
    ECONOMICS("Economics"),
    SOCIAL_STUDIES("Social Studies"),
    COMPUTER_SCIENCE("Computer Science");

    private final String value;

    Subjects(String value){this.value = value;}

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

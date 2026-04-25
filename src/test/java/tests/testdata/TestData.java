package tests.testdata;

import com.github.javafaker.Faker;

public class TestData {
    static Faker faker = new Faker();
    public static String simpleFormUrl = "/text-box";
    public static String practiceFormUrl = "/automation-practice-form";
    public static String imageName = "image.jpg";
    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String userName = firstName + " " + lastName;
    public static String dayOfBirth = String.valueOf(faker.number().numberBetween(1,28));
    public static String monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public static String yearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2100));
    public static String userEmail = faker.internet().emailAddress();
    public static String gender = faker.options().option("Male", "Female", "Other");
    public static String userNumber = String.valueOf(faker.number().digits(10));
    public static String currentAddress = faker.address().fullAddress();
    public static String incorrectUserEmail = faker.letterify("?????");
    public static String incorrectUserNumber = faker.numerify("?????");
    public static String subjectsInput = faker.options().option("Maths", "Arts", "English", "History");
    public static String hobby = faker.options().option("Sports", "Reading", "Music");
    public static String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public static String city = getCityByState(state);

    public static String getCityByState(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }

}

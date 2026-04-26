package tests.testdata;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    public static String simpleFormUrl = "/text-box";
    public static String practiceFormUrl = "/automation-practice-form";
    public static String imageName = "image.jpg";

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userName = firstName + " " + lastName;
    public String dayOfBirth = String.valueOf(faker.number().numberBetween(1,28));
    public String monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public String yearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2100));
    public String userEmail = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String currentAddress = faker.address().fullAddress();
    public String incorrectUserEmail = faker.letterify("?????");
    public String incorrectUserNumber = faker.numerify("#####");
    public String subjectsInput = faker.options().option("Maths", "Arts", "English", "History");
    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getCityByState(state);

    public String getCityByState(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }

}

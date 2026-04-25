package utils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomString(9));
        System.out.println(getRandomEmail());
        System.out.println(getRandomGender());

    }

    public static String getRandomEmail() {
        return format("%s@%s.com", getRandomString(5), getRandomString(5)).toLowerCase();
    }

    public static String getRandomString(int length) {

        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXY";
        StringBuilder result = new StringBuilder();
        Random rnd = new SecureRandom();

        for (int i = 0; i < length; i++) {
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));
        }
        return result.toString();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender_bad_practice() {
        String[] genders = {"Male", "Female", "Other"};
        int randomIndex = getRandomInt(0, 2);
        return genders[randomIndex];
    }

    public static String getRandomGender(){
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromStringArray(genders);
    }

    public static String getRandomItemFromStringArray(String[] stringArray){

        int arrayLength = stringArray.length;
        int randomIndex = getRandomInt(0, arrayLength-1);

        return stringArray[randomIndex];

    }

}

package utilities;

import com.github.javafaker.Faker;

public class Utility {
    static int randomNumber;
    static Faker faker = new Faker();

    public static int generateRandomNumber() {
        randomNumber = (int) (Math.random() * 6) + 1;
        return randomNumber;
    }

    public static String generateRandomFirstname() {
        String firstname = faker.name().firstName();
        return firstname;
    }

    public static String generateRandomLastname() {
        String lastname = faker.name().lastName();
        return lastname;
    }
    public static String generateRandomZip(){
        String zip = faker.address().zipCode();
        return zip;
    }
}

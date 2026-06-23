package POM.utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "studentData")
    public static Object[][] getStudentData(){

        String timestamp = String.valueOf(System.currentTimeMillis());
        return new Object[][]{

                {
                        "Student" + timestamp,
                        "Amar",
                        "student" + timestamp + "@gmail.com",
                        "01092010",
                        "StudentUser" + timestamp,
                        "Amar@0601"
                },

        };
    }

    @DataProvider(name = "adultData")
    public static Object[][] getAdultData(){

        String timestamp = String.valueOf(System.currentTimeMillis());
        return new Object[][]{

                {
                        "Adult" + timestamp,
                        "User1",
                        "adult" + timestamp + "@gmail.com",
                        "09081999",
                        "AdultUser" + timestamp,
                        "Amar@0601"
                },
        };
    }
    @DataProvider(name = "multiTravelerData")
    public static Object[][] getMultiTravelerData() {

        String ts = String.valueOf(System.currentTimeMillis());

        return new Object[][]{

                {
                        "Student" + ts,
                        "Test",
                        "student" + ts + "@gmail.com",
                        "01012010",

                        "Adult" + ts,
                        "User",
                        "adult" + ts + "@gmail.com",
                        "08022000",

                        "Responsible" + ts,
                        "Guardian",
                        "responsible" + ts + "@gmail.com",

                        "User" + ts,
                        "Amar@0601"
                }
        };
    }
}
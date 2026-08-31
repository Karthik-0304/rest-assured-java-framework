package com.api.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserDataDrivenTests {

    @DataProvider(name = "userDataProvider")
    public Object[][] getUserData() {
        return new Object[][] {
                {"Karthik", "SDET"},
                {"Rahul", "Developer"},
                {"Priya", "QA Lead"}
        };
    }

    @Test(dataProvider = "userDataProvider")
    public void testCreateUserWithMultipleData(String name, String job) {
        String requestBody = "{\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"job\": \"" + job + "\"\n" +
                "}";

        // Pass payload to your client and assert success
        System.out.println("Testing creation for: " + name + " as " + job);
    }
}
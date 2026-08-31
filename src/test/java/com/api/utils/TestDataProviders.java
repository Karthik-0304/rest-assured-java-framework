package com.api.utils;

import org.testng.annotations.DataProvider;

public class TestDataProviders {

    @DataProvider(name = "userCreationData")
    public static Object[][] getUserData() {
        return new Object[][] {
                {"Karthik", "Lead SDET"},
                {"Rahul", "Automation Engineer"},
                {"Priya", "QA Manager"}
        };
    }
}
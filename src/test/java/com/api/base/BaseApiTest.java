package com.api.base;

import com.api.utils.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {

    public static RequestSpecification  requestSpec;
    public static ResponseSpecification responseSpec;

    @BeforeClass
    public void setupBaseConfiguration(){

        RestAssured.baseURI =  ConfigLoader.getPropertyFile("baseURI");

        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Accept","application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();


        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }
}

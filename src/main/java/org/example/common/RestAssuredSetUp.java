package org.example.common;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class RestAssuredSetUp {

    public void setupassureddefault(){

        RequestSpecBuilder builder= new RequestSpecBuilder();
        builder.setContentType("application/json").setRelaxedHTTPSValidation().setBasePath("http://localhost:8080");
        Authenticator authenticator=new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return (new PasswordAuthentication("user","password".toCharArray()));
            }
        };
        Authenticator.setDefault(authenticator);
        builder.build();
    }

    public static void setRequestspec() {

        RequestSpecification builder = RestAssured.given()
                .baseUri("https://api.example.com")
                .basePath("/api/v1")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer your_token_here")
                .queryParam("locale", "en_US");
    }
}

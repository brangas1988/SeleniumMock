package org.example.common;

import io.cucumber.java.Scenario;
import io.restassured.internal.support.Prettifier;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.filter.log.LogDetail;
import io.restassured.internal.print.RequestPrinter;
import org.apache.commons.io.output.WriterOutputStream;

import java.io.PrintStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class RequestLoggingFilter implements Filter {

    private final Scenario scenario;

    public RequestLoggingFilter(Scenario scenario) {
        this.scenario = scenario;
    }

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        // Capture the request body
       // StringWriter writer = new StringWriter();
        System.out.println("REQUEST SPEC--->"+requestSpec.getMethod());
        //ctx.
        String requestBody = new Prettifier().getPrettifiedBodyIfPossible(requestSpec);
        scenario.log("Url->"+ requestSpec.getURI() +"\n"+ "Request Body:\n" + requestBody);
        // Proceed with the request
        return ctx.next(requestSpec, responseSpec);
    }
}

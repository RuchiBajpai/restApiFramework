package com.ruchi.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;

import static io.restassured.RestAssured.get;

public class StudentControllerApiRestAssured {
    String baseURL = "http://localhost:8081/api/students/";


    public Response getCall(int studentid) {
        Response response = get( baseURL+ studentid);
        return response;

    }

    public Response postCall(String jsonString) throws JSONException {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(jsonString);
        Response response = request.post(baseURL);
        return response;
    }

    public Response putCall(String jsonString, int studentid) throws Exception {
        RequestSpecification request = RestAssured.given();
        request
                .header("Content-Type", "application/json");
        request.body(jsonString);
        Response response = request.put(baseURL + studentid);
        return response;


    }
    public int deleteCall(int studentid) {

        RequestSpecification request = RestAssured.given();
        Response response = request.delete(baseURL + studentid);
        int code = response.getStatusCode();
        System.out.println(code);
        return  code;

    }

}



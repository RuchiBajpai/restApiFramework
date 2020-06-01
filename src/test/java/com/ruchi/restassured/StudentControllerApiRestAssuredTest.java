package com.ruchi.restassured;

import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentControllerApiRestAssuredTest {

    StudentControllerApiRestAssured resapi = new StudentControllerApiRestAssured();

    @Test
    @Order(1)
    public void testPostCallWithValidData() throws JSONException {
        String studentJson = "{ \"firstName\": \"Ruchi1\", \"id\": 0, \"lastName\": \"Test1\", \"nationality\": \"Indian\", \"studentClass\": \"Grade1\"}";
        Response response = resapi.postCall(studentJson);
        int code = response.getStatusCode();
        String respBody = response.getBody().asString();
        System.out.println(respBody);
        JSONObject jo = new JSONObject(respBody);
        String firstName = jo.getString("firstName");
        Assertions.assertEquals("Ruchi1", firstName);
        Assertions.assertEquals(200, code);
    }

    @Test
    @Order(2)
    public void testPostCallWithInValidData() throws JSONException {
        String studentJson = "{ \"firstName\": \"Ruchi1\", \"lastName\": \"Test1\", \"nationality\": \"Indian\", \"studentClass\": \"Grade1\"}";
        Response response = resapi.postCall(studentJson);
        int code = response.getStatusCode();
        String respBody = response.getBody().asString();
        System.out.println(code);
        System.out.println(respBody);
        Assertions.assertEquals(500, code);
    }

    @Test
    @Order(3)
    public void testGetCallWithValidData() throws JSONException {
        Response response = resapi.getCall(0);
        int code = response.getStatusCode();
        String respBody = response.getBody().asString();
        JSONObject jo = new JSONObject(respBody);
        String firstName = jo.getString("firstName");
        String lastName = jo.getString("lastName");
        String studentClass = jo.getString("studentClass");
        String nationality = jo.getString("nationality");
        Assertions.assertEquals("Ruchi1", firstName);
        Assertions.assertEquals("Test1", lastName);
        Assertions.assertEquals("Grade1", studentClass);
        Assertions.assertEquals("Indian", nationality);
        Assertions.assertEquals(200,code);

    }

    @Test
    @Order(4)
    public void testGetCallWithInValidData(){
        Response response = resapi.getCall(100);
        int code = response.getStatusCode();
        Assertions.assertEquals(404,code);
    }

    @Test
    @Order(5)
    public void testPutCallWithValidData() throws Exception {
        String studentJson = "{ \"firstName\": \"Ruchi3\", \"id\": 0, \"lastName\": \"Test1\", \"nationality\": \"Indian\", \"studentClass\": \"Grade1\"}";
        Response response  = resapi.putCall(studentJson, 0);
        int code = response.getStatusCode();
        String respBody = response.getBody().asString();
        JSONObject jo = new JSONObject(respBody);
        String firstName = jo.getString("firstName");
        Assertions.assertEquals("Ruchi3", firstName);
        Assertions.assertEquals(200,code);
    }


    @Test
    @Order(6)
    public void testPutCallWithInValidData() throws Exception {
        String studentJson = "{ \"firstName\": \"Ruchi3\", \"lastName\": \"Test1\", \"nationality\": \"Indian\", \"studentClass\": \"Grade1\"}";
        Response response= resapi.putCall(studentJson,0);
        int code = response.getStatusCode();
        Assertions.assertEquals(500,code);
    }

    @Test
    @Order(7)
    public void testdeleteCallWithValidData(){
        int resstatuscode = resapi.deleteCall(0);
        Assertions.assertEquals(200,resstatuscode);

    }

    @Test
    @Order(8)
    public void testdeleteCallWithInValidData(){
        int resstatuscode = resapi.deleteCall(100);
        Assertions.assertEquals(404,resstatuscode);

    }

}



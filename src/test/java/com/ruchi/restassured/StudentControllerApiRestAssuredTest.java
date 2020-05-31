package com.ruchi.restassured;

import org.json.JSONException;
import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentControllerApiRestAssuredTest {

    StudentControllerApiRestAssured resapi = new StudentControllerApiRestAssured();

    @Test
    @Order(1)
    public void testPostCallWithValidData() throws JSONException {
        String studentJson = "{ \"firstName\": \"Ruchi1\", \"id\": 0, \"lastName\": \"Test1\", \"nationality\": \"Indian\", \"studentClass\": \"Grade1\"}";
        int resstatuscode = resapi.postCall(studentJson);
        Assertions.assertEquals(200, resstatuscode);
    }

    @Test
    @Order(2)
    public void testPostCallWithInValidData() throws JSONException {
        String studentJson = "{ \"firstName\": \"Ruchi1\", \"lastName\": \"Test1\", \"nationality\": \"Indian\", \"studentClass\": \"Grade1\"}";
        int resstatuscode = resapi.postCall(studentJson);
        Assertions.assertEquals(500,resstatuscode);
    }

    @Test
    @Order(3)
    public void testGetCallWithValidData(){
        int resstatuscode = resapi.getCall(0);
        Assertions.assertEquals(200,resstatuscode);

    }

    @Test
    @Order(4)
    public void testGetCallWithInValidData(){
        int resstatuscode = resapi.getCall(100);
        Assertions.assertEquals(404,resstatuscode);
    }

    @Test
    @Order(5)
    public void testPutCallWithValidData() throws Exception {
        String studentJson = "{ \"firstName\": \"Ruchi3\", \"id\": 0, \"lastName\": \"Test1\", \"nationality\": \"Indian\", \"studentClass\": \"Grade1\"}";
        int resstatuscode = resapi.putCall(studentJson, 0);
        Assertions.assertEquals(200,resstatuscode);
    }


    @Test
    @Order(6)
    public void testPutCallWithInValidData() throws Exception {
        String studentJson = "{ \"firstName\": \"Ruchi3\", \"lastName\": \"Test1\", \"nationality\": \"Indian\", \"studentClass\": \"Grade1\"}";
        int resstatuscode = resapi.putCall(studentJson,0);
        Assertions.assertEquals(500,resstatuscode);
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



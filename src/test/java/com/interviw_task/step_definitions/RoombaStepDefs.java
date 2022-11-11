package com.interviw_task.step_definitions;

import com.interviw_task.utilities.ConfigurationReader;
import com.interviw_task.utilities.CoordinateInput;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Arrays;

import static io.restassured.RestAssured.*;

public class RoombaStepDefs {

    Response response;
    // made each variable global so that I am able to test out different coordinates to make sure im getting different results
    int[] roomSize = {5, 5};
    int[] coords = {1, 2};
    int[][] patches = {{1, 0}, {2, 2}, {2, 3}};
    String instructions = "NNESEESWNWW";

    String body = "{ \"roomSize\" :" + Arrays.toString(roomSize) + ",\"coords\" : " + Arrays.toString(coords) + ",\"patches\" : " + Arrays.deepToString(patches) + ",\"instructions\" : \"" + instructions + "\"}"; // grouped up each variable into single String variable

    @Given("Users sends POST request to {string}") // sending a post request in order send data to server
    public void users_sends_POST_request_to(String endPoint) {

        System.out.println("Request body: " + body);
        response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(body)
                .when().post(ConfigurationReader.getProperty(endPoint));
    }

    @Then("output should match expected")
    public void output_should_match_expected() {
        Assert.assertEquals(CoordinateInput.result(roomSize, coords, patches, instructions), response.getBody().asString());
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("Response body: " + response.getBody().asString());
    }




}

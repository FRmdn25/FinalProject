package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {

    String setURL, global_id;
    Response res;

    public void prepareUrlFor(String url) {
        switch (url) {
            case "GET_LIST_USERS":
                setURL = Endpoint.GET_LIST_USERS;
                break;
            case "CREATE_NEW_USERS":
                setURL = Endpoint.CREATE_USER;
                break;
            case "DELETE_USERS":
                setURL = Endpoint.DELETE_USER;
                break;
            default:
                System.out.println("input right url");
        }
    }

    public void hitApiGetListUsers(){
        res = getListUsers(setURL);
        System.out.println(res.getBody().asPrettyString());

    }

    public void hitApiPostCreateUsers(){
        res = postCreateUser(setURL);
    }

    public void validationStatusCodeIsEqual(int status_code){
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationResponseBodyGetListUsers() {
        List<Object> id = res.jsonPath().getList("data.id");
        List<Object> firstName = res.jsonPath().getList("data.firstName");
        List<Object> lastName = res.jsonPath().getList("data.lastName");
        List<Object> picture = res.jsonPath().getList("data.picture");

        assertThat(id).isNotEmpty();
        assertThat(firstName).isNotEmpty();
        assertThat(lastName).isNotEmpty();
        assertThat(picture).isNotEmpty();

        assertThat(id.get(0)).isNotNull();
        assertThat(firstName.get(0)).isNotNull();
        assertThat(lastName.get(0)).isNotNull();
        assertThat(picture.get(0)).isNotNull();
    }

    public void validationResponseJsonWithJSONSchema(String filename){
        File JSONFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void validationResponseBodyCreateUser(){
        JsonPath jsonPath = res.jsonPath();
        String id = jsonPath.getString("id");
        String firstName = jsonPath.getString("firstName");
        String lastName = jsonPath.getString("lastName");
        String email = jsonPath.getString("email");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();

        global_id = id;
    }

    public void hitApiDeleteUser(){
        res = deleteUser(setURL, global_id);
    }

    public void hitApiUpdateUser() {
        throw new UnsupportedOperationException("DummyAPI does not support update user via PATCH.");
    }

    public void validationResponseBodyUpdateUser(){
        throw new UnsupportedOperationException("DummyAPI does not support update user via PATCH.");
    }
}

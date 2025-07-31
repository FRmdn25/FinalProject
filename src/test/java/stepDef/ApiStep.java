package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStep {
    ApiPage apiPage;

    public ApiStep() {
        this.apiPage = new ApiPage();
    }

    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.prepareUrlFor(url);
    }

    @And("hit api get list users")
    public void hitApiGetListUsers() {
        apiPage.hitApiGetListUsers();
    }

    @Then("validation status code is equal {int}")
    public void validationStatusCodeIsEqual(int status_code) {
        apiPage.validationStatusCodeIsEqual(status_code);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationResponseBodyGetListUsers();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        apiPage.validationResponseJsonWithJSONSchema(filename);
    }

    @And("hit api post create new users")
    public void hitApiPostCreateNewUsers() {
        apiPage.hitApiPostCreateUsers();
    }

    @Then("validation response body post create new user")
    public void validationResponseBodyPostCreateNewUser() {
        apiPage.validationResponseBodyCreateUser();
    }

    @And("hit api delete new")
    public void hitApiDeleteNew() {
        apiPage.hitApiDeleteUser();
    }

    // DummyAPI tidak support update, jadi kita nonaktifkan
    @And("hit api update data")
    public void hitApiUpdateData() {
        throw new UnsupportedOperationException("DummyAPI does not support update user.");
    }

    @Then("validation response body update user")
    public void validationResponseBodyUpdateUser() {
        throw new UnsupportedOperationException("DummyAPI does not support update user.");
    }
}

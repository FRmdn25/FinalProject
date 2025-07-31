package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.generateRandomEmail;

public class Models {

    private static RequestSpecification request;

    // Setup header khusus DummyAPI
    public static void setupHeaders() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "63a804408eb0cb069b57e43a"); // Ganti dengan App ID kamu dari dummyapi.io
    }

    // Mendapatkan daftar user
    public static Response getListUsers(String endpoint) {
        setupHeaders();
        return request.when().get(endpoint);
    }

    // Membuat user (simulasi, DummyAPI hanya test endpoint)
    public static Response postCreateUser(String endpoint) {
        String firstName = "Fachri";
        String lastName = "Ramdani";
        String email = generateRandomEmail();

        JSONObject payload = new JSONObject();
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("email", email);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    // Menghapus user (DummyAPI hanya simulasi)
    public static Response deleteUser(String endpoint, String user_id) {
        setupHeaders();
        String finalEndpoint = endpoint + user_id;
        return request.when().delete(finalEndpoint);
    }

    // DummyAPI tidak support PATCH/PUT, jadi fungsi ini tidak digunakan
    public static Response updateUser(String endpoint, String user_id) {
        throw new UnsupportedOperationException("DummyAPI does not support update user via PATCH.");
    }
}

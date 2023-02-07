package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class test {
    @Test
    public void shouldReturnDemoAccounts() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("25/12/1989") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("25/12/1989"));
    }

    @Test
    void shouldReturnDemoAccounts1() {
        given()
                .baseUri("https://postman-echo.com")
                .body("id:2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("id:2"));
    }

    @Test
    void shouldReturnDemoAccounts3() {
        given()
                .baseUri("https://postman-echo.com")
                .body("currency:RUB")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("currency:RUB"));
    }

}

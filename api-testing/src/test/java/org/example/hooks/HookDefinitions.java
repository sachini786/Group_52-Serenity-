package org.example.hooks;

import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.mapper.ObjectMapperType;
import lombok.Getter;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.example.models.Book;

public class HookDefinitions {
    @Getter
    private static int createdBookIDForUpdate;
    @Getter
    private static int createdBookIDForUpdateAndDelete;
    @Getter
    private static int createdBookIDForDelete;
    private static String title;
    private static String author;
    private final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private final String BASE_URL = environmentVariables.getProperty("api.baseurl");
    private final String USER = environmentVariables.getProperty("api.user.username");
    private final String USER_PASSWORD = environmentVariables.getProperty("api.user.password");
    private final String ADMIN = environmentVariables.getProperty("api.admin.username");
    private final String ADMIN_PASSWORD = environmentVariables.getProperty("api.admin.password");

    @Before(value = "@CreateBookForDelete")
    public void CreateBookForDelete() {

        title = Faker.instance().book().title();
        author = Faker.instance().book().author();

        String requestBody = String.format("""
                {
                "title": "%s",
                "author": "%s"
                }
                """, title, author);
        createdBookIDForDelete = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic(USER, USER_PASSWORD)
                .body(requestBody)
                .header("Content-Type", "application/json")
                .post("api/books")
                .getBody().as(Book.class, ObjectMapperType.JACKSON_2).id();
    }

    @Before(value = "@CreateBookForUpdate")
    public void CreateBookForUpdate() {

        title = Faker.instance().book().title();
        author = Faker.instance().book().author();

        String requestBody = String.format("""
                {
                "title": "%s",
                "author": "%s"
                }
                """, title, author);
        createdBookIDForUpdate = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic(ADMIN, ADMIN_PASSWORD)
                .body(requestBody)
                .header("Content-Type", "application/json")
                .post("api/books")
                .getBody().as(Book.class, ObjectMapperType.JACKSON_2).id();

    }

    @Before(value = "@CreateBookForUpdateAndDelete")
    public void CreateBookForUpdateAndDelete() {

        title = Faker.instance().book().title();
        author = Faker.instance().book().author();

        String requestBody = String.format("""
                {
                "title": "%s",
                "author": "%s"
                }
                """, title, author);
        createdBookIDForUpdateAndDelete = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic(ADMIN, ADMIN_PASSWORD)
                .body(requestBody)
                .header("Content-Type", "application/json")
                .post("api/books")
                .getBody().as(Book.class, ObjectMapperType.JACKSON_2).id();

    }

    @After(value = "@CreateBookForUpdateAndDelete")
    public void DeleteUpdateBook() {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic(USER, USER_PASSWORD)
                .header("Content-Type", "application/json")
                .delete(String.format("api/books/%d", createdBookIDForUpdateAndDelete));

    }

}

package org.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.mapper.ObjectMapperType;
import lombok.Getter;
import net.serenitybdd.rest.SerenityRest;
import com.github.javafaker.Faker;
import org.example.models.Book;

public class HookDefinitions {
    private static final String BASE_URL = "http://localhost:7081/api";
    @Getter
    private static int createdBookIDForUpdate;
    @Getter
    private static int createdBookIDForUpdateAndDelete;
    @Getter
    private static int createdBookIDForDelete;
    private static String title;
    private static String author;

    @Before(value="@CreateBookForDelete")
    public void CreateBookForDelete(){

        title=Faker.instance().book().title();
        author=Faker.instance().book().author();

        String requestBody =String.format("""
                {
                "title": "%s",
                "author": "%s"
                }
                """,title,author);
        createdBookIDForDelete = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic("user","password")
                .body(requestBody)
                .header("Content-Type", "application/json")
                .post("/books")
                .getBody().as(Book.class, ObjectMapperType.JACKSON_2).id();
    }

    @Before(value="@CreateBookForUpdate")
    public void CreateBookForUpdate(){

        title=Faker.instance().book().title();
        author=Faker.instance().book().author();

        String requestBody =String.format("""
                {
                "title": "%s",
                "author": "%s"
                }
                """,title,author);
        createdBookIDForUpdate = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic("admin","password")
                .body(requestBody)
                .header("Content-Type", "application/json")
                .post("/books")
                .getBody().as(Book.class, ObjectMapperType.JACKSON_2).id();

    }

    @Before(value="@CreateBookForUpdateAndDelete")
    public void CreateBookForUpdateAndDelete(){

        title=Faker.instance().book().title();
        author=Faker.instance().book().author();

        String requestBody =String.format("""
                {
                "title": "%s",
                "author": "%s"
                }
                """,title,author);
        createdBookIDForUpdateAndDelete = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic("admin","password")
                .body(requestBody)
                .header("Content-Type", "application/json")
                .post("/books")
                .getBody().as(Book.class, ObjectMapperType.JACKSON_2).id();

    }
    @After(value="@CreateBookForUpdateAndDelete")
    public void DeleteUpdateBook(){
        SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic("user","password")
                .header("Content-Type", "application/json")
                .delete(String.format("/books/%d",createdBookIDForUpdateAndDelete));

    }

}

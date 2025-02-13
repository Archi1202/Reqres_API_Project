package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class Specs {
    public static final ResponseSpecification response200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.ALL)
            .build();

    public static final ResponseSpecification response204 = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(LogDetail.ALL)
            .build();

    public static final ResponseSpecification response400 = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(LogDetail.ALL)
            .build();

    public static final RequestSpecification commonRequest = with()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .log().all();
}
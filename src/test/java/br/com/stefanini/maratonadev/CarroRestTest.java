package br.com.stefanini.maratonadev;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;


@QuarkusTest
public class CarroRestTest {

	@Test
	public void testListarCarros() {
		given()
		.when().get("/api/carro")
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.body(is("[{\"ano\":2015,\"disponivel\":true,\"marca\":\"GM - Chevrolet\",\"modelo\":\"Bonanza S  Luxe 4.1\",\"placa\":\"GWK8629\"},{\"ano\":1990,\"disponivel\":false,\"marca\":\"GM - Chevrolet\",\"modelo\":\"SONIC Sed. LTZ 1.6 16V FlexPower 4p Aut.\",\"placa\":\"BQW0877\"}]"));			
	}
}

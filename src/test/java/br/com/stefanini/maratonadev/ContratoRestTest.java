package br.com.stefanini.maratonadev;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class ContratoRestTest {

	@Test
	@Order(1)
	public void testCriarContratoComSucesso() {
		String body = "09987674056";
		given()
		.contentType(ContentType.JSON)
		.body(body)
		.when()
		.post("/api/contrato/{placa}","GWK8629")
		.then()
		.statusCode(201);
	}
	
	@Test
	@Order(2)
	public void testClienteContratoAtivo() {
		String body = "38466546464";
		given()
		.contentType(ContentType.JSON)
		.body(body)
		.when()
		.post("/api/contrato/{placa}","GWK8629")
		.then()
		.statusCode(500)
		.body(is("Cliente com contrato ativo"));
	}
	
	@Test
	@Order(3)
	public void testCarroInsdisponivel() {
		String body = "09987674056";
		given()
		.contentType(ContentType.JSON)
		.body(body)
		.when()
		.post("/api/contrato/{placa}","BQW0877")
		.then()
		.statusCode(500)
		.body(is("Carro Indisponivel"));
	}
	
	@Test
	@Order(4)
	public void testClienteNaoCadastrado() {
		String body = "12345678654";
		given()
		.contentType(ContentType.JSON)
		.body(body)
		.when()
		.post("/api/contrato/{placa}","BQW0877")
		.then()
		.statusCode(404)
		.body(is("Cliente não cadastrado"));
	}
	
	
	@Test
	@Order(5)
	public void testDesativarContratoComSucesso() {
		given()
		.when()
		.put("/api/contrato/{id}",3)
		.then()
		.statusCode(200);
	}
	
	
}

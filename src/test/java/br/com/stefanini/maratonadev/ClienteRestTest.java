package br.com.stefanini.maratonadev;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;


@QuarkusTest
public class ClienteRestTest {

	@Test
	@Order(1)
	public void testListarClientes() {
		given()
		.when().get("/api/cliente")
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.body(is("[{\"bairro\":\"phasellus in\",\"cep\":\"21857863\",\"cidade\":\"Sterling\",\"complemento\":\"tincidunt\",\"contato\":\"21956679098\",\"cpf\":\"38466546464\",\"email\":\"esimonot0@apple.com\",\"id\":1,\"logradouro\":\"9068 Anniversary Road\",\"nome\":\"Elnore Simonot\",\"uf\":\"VA\"},{\"bairro\":\"erat\",\"cep\":\"21514256\",\"cidade\":\"Vero Beach\",\"complemento\":\"nulla\",\"contato\":\"21998299755\",\"cpf\":\"09987674056\",\"email\":\"jann1@amazon.de\",\"id\":2,\"logradouro\":\"8327 Rowland Court\",\"nome\":\"Jo ann Arger\",\"uf\":\"FL\"}]"));			
	}
	
	@Test
	@Order(2)
	public void testCadastrarClienteComSucesso() {
		String body = 
				 "{\"bairro\":\"Portuguesa\",\"cep\":\"21931576\",\"cidade\":\"Rio de Janeiro\","
				 + "\"complemento\":\"n 10\",\"contato\":\"2172456789\",\"cpf\":\"12456787654\","
				 + "\"email\":\"ada@email.com\",\"logradouro\":\"Rua Gustavo Augusto de Resende\","
				 + "\"nome\":\"Ada\",\"uf\":\"RJ\"}";
		given()
		.contentType(ContentType.JSON)
		.body(body)
		.when()
		.post("/api/cliente")
		.then()
		.statusCode(201);
		
	}
	
	@Test
	@Order(3)
	public void testCadastroComCpfJaCadastrado() {
		String body = 
				 "{\"bairro\":\"Portuguesa\",\"cep\":\"21931576\",\"cidade\":\"Rio de Janeiro\","
				 + "\"complemento\":\"n 10\",\"contato\":\"21981456789\",\"cpf\":\"38466546464\","
				 + "\"email\":\"ada@email.com\",\"logradouro\":\"Rua Gustavo Augusto de Resende\","
				 + "\"nome\":\"Ada\",\"uf\":\"RJ\"}";
		given()
		.contentType(ContentType.JSON)
		.body(body)
		.when()
		.post("/api/cliente")
		.then()
		.statusCode(400)
		.body(is("Este CPF já está cadastrado"));
		
	}
	
}

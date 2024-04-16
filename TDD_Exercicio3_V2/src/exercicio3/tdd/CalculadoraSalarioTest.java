package exercicio3.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraSalarioTest {

	@Test
	public void testCalculadoraSalarioDesenvolvedor_SalarioAlto() {
		Empregado desenvolvedor = new Empregado("Lucas Nadalete", "lucas@fatec.com.br", 3500.0, Cargo.DESENVOLVEDOR);
		double salarioEsperado = 3500.0 * 0.8;
		
		double salarioCalculado = CalculadoraSalario.calculaSalario(desenvolvedor);
		
		assertEquals(salarioEsperado, salarioCalculado);
	}
	
	@Test
	public void testCalculadoraSalarioDesenvolvedor_SalarioBaixo() {
		Empregado desenvolvedor = new Empregado("Maria Souza", "maria@fatec.com.br", 2500.0, Cargo.DESENVOLVEDOR);
		double salarioEsperado = 2500.0 * 0.9;
		
		double salarioCalculado = CalculadoraSalario.calculaSalario(desenvolvedor);
		
		assertEquals(salarioEsperado, salarioCalculado);
	}
	
	@Test
	public void testCalculadoraSalarioDBA_SalarioAlto() {
		Empregado dba = new Empregado("Elizabeth Leite", "elizabeth@fatec.com.br", 2500.0, Cargo.DBA);
		double salarioEsperado = 2500.0 * 0.75;
		
		double salarioCalculado = CalculadoraSalario.calculaSalario(dba);
		
		assertEquals(salarioEsperado, salarioCalculado);
	}
	
	@Test
	public void testCalculadoraSalarioDBA_SalarioBaixo() {
		Empregado dba = new Empregado("Ana Lima", "ana@fatec.com.br", 1800.0, Cargo.DBA);
		double salarioEsperado = 1800.0 * 0.85;
		
		double salarioCalculado = CalculadoraSalario.calculaSalario(dba);
		
		assertEquals(salarioEsperado, salarioCalculado);
	}
	
	@Test
	public void testCalculadoraSalarioTestador_SalarioAlto() {
		Empregado testador = new Empregado("Pedro Silva", "pedro@fatec.com.br", 2200.0, Cargo.TESTADOR);
		double salarioEsperado = 2200.0 * 0.75;
		
		double salarioCalculado = CalculadoraSalario.calculaSalario(testador);
		
		assertEquals(salarioEsperado, salarioCalculado);
	}
	
	@Test
	public void testCalculadoraSalarioTestador_SalarioBaixo() {
		Empregado testador = new Empregado("Maria Santos", "maria@fatec.com.br", 1800.0, Cargo.TESTADOR);
		double salarioEsperado = 1800 * 0.85;
		
		double salarioCalculado = CalculadoraSalario.calculaSalario(testador);
		
		assertEquals(salarioEsperado, salarioCalculado);
	}
	
	@Test
	public void testCalculadoraSalarioGestor_SalarioAlto() {
		Empregado gestor = new Empregado("João Souza", "joao@fatec.com.br", 6000.0, Cargo.GESTOR);
		double salarioEsperado = 6000.0 * 0.7;
		
		double salarioCalculado = CalculadoraSalario.calculaSalario(gestor);
		
		assertEquals(salarioEsperado, salarioCalculado);
	}
	
	@Test
	public void testCalculadoraSalarioGestor_SalarioBaixo() {
		Empregado gestor = new Empregado("Ana Oliveira", "ana@fatec.com.br", 4500.0, Cargo.GESTOR);
		double salarioEsperado = 4500.0 * 0.8;
		
		double salarioCalculado = CalculadoraSalario.calculaSalario(gestor);
		
		assertEquals(salarioEsperado, salarioCalculado);
	}
	
	@Test
	public void testCalculadoraSalarioGestor_SalarioLimite() {
		Empregado gestor = new Empregado("Carlos Silva", "carlos@fatec.com.br", 5000.0, Cargo.GESTOR);
	    double salarioEsperado = 5000.0 * 0.7;

	    double salarioCalculado = CalculadoraSalario.calculaSalario(gestor);

	    double margemTolerancia = 0.01; 
	    assertEquals(salarioEsperado, salarioCalculado, margemTolerancia);
	}

}

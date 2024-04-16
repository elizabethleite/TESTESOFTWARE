package exercicio3.tdd;

public class CalculadoraSalario {
	
	public static double calculaSalario(Empregado empregado) {
		double descontoSalario = getDescontoSalario(empregado.getCargo(), empregado.getSalarioBase());
		double salarioLiquido = empregado.getSalarioBase() * (1 - descontoSalario);
		return salarioLiquido;
	}
	
	private static double getDescontoSalario(Cargo cargo, double salarioBase) {
		switch(cargo){
		case DESENVOLVEDOR:
			return salarioBase >= 3000.0 ? 0.2 : 0.1;
			
		case DBA:
			return salarioBase >= 2000.0 ? 0.25 : 0.15;
			
		case TESTADOR:
			return salarioBase >= 2000.0 ? 0.25 : 0.15;
			
		case GESTOR:
			return salarioBase >= 5000.0 ? 0.3 : 0.2;
		default:
			return 0.0;
		}
	}

}



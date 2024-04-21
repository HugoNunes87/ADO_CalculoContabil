package calculocontabil;

public class Ganhos {
	public static double salario, bonus, horaExtra, total;
	
	public static double HoraExtra(double salario, double cargaHorariaMensal, double horasExtras){
		
		double salarioHora = salario/cargaHorariaMensal;
		
		horaExtra = ((salarioHora*0.5)+salarioHora)*horasExtras;
		
		return horaExtra;
	}
	
	
	public static double GanhosTotais(double salario, double bonusFuncionario, double horasExtras, int cargaHorariaMensal){
		
		horaExtra = Ganhos.HoraExtra(salario, cargaHorariaMensal, horasExtras);
		
		bonus = bonusFuncionario;
		
		total = salario+horaExtra+bonus;
		
		return total;
		}
	
}

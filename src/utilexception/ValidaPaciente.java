package utilexception;

import java.time.LocalDate;

import exception.CadastroPacienteException;

public class ValidaPaciente {
	
	public void nomePaciente(String nome) throws CadastroPacienteException{
		if (nome == null || nome.trim().isEmpty()) {
			throw new CadastroPacienteException(" Nome do paciente nao pode ser vazio.");
		}
	}
	
	public void tipoSanguinio(String tipo) throws CadastroPacienteException{
		if (!tipo.equals("A+") && !tipo.equals("A-") && !tipo.equals("AB+") && !tipo.equals("AB-") 
				&& !tipo.equals("O+") && !tipo.equals("O-") && !tipo.equals("B+") && !tipo.equals("B-")) {
			throw new CadastroPacienteException(" Tipo sanguineo invalido.");
		}
	}
	
	
	public void pesoPaciente(double peso) throws CadastroPacienteException{
		if (peso < 0) {
			throw new CadastroPacienteException(" Peso do paciente nao pode ser negativo.");
		}
	}
	
	public void dataInvalida(String data) throws CadastroPacienteException{
		try {
			String[] valores = data.split("/");
			LocalDate ano = LocalDate.of(Integer.parseInt(valores[2]), Integer.parseInt(valores[1]),Integer.parseInt(valores[0]));
		} catch (Exception e) {
			throw new CadastroPacienteException(" Data invalida.");
		}
	}
	
	public void pacienteCadastrado(boolean existe) throws CadastroPacienteException{
		if (existe) {
			throw new CadastroPacienteException(" Paciente ja cadastrado.");
		}
	}
	

}

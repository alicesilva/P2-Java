package prontuario;

import java.time.LocalDate;

public class Paciente{

	public static final String LINESEPARATOR = System.lineSeparator();
	public static final String NOME = "Nome";
	public static final String DATA = "Data";
	public static final String PESO = "Peso";
	public static final String TIPOSANGUINEO = "TipoSanguineo";
	public static final String SEXO = "Sexo";
	public static final String GENERO = "Genero";
	
	private String nomePaciente;
	private String dataDeNascimento;
	private double peso;
	private String tipoSanguineo;
	private String sexoBiologico;
	private String genero;
	
	public Paciente(String nomePaciente, String dataNascimento, double peso,
			String tipoSanguineo, String sexoBiologico, String genero){
		
		this.nomePaciente = nomePaciente;
		this.dataDeNascimento = dataNascimento;
		this.peso = peso;
		this.tipoSanguineo = tipoSanguineo;
		this.sexoBiologico = sexoBiologico;
		this.genero = genero;
	}

	
	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) throws StringInvalidaException{
		if(nomePaciente == null || nomePaciente.trim().isEmpty()){
			throw new StringInvalidaException();
		}
		this.nomePaciente = nomePaciente;
	}


	public String getDataDeNascimento() {
		return this.dataDeNascimento;
	}


	public void setDataDeNascimento(String dataNascimento) throws StringInvalidaException{
		if(dataDeNascimento == null || dataDeNascimento.trim().isEmpty()){
			//throw new StringInvalidaException();
		}
		this.dataDeNascimento = dataNascimento;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) throws ValorInvalidoException{
		if(peso < 0){
			throw new ValorInvalidoException();
		}
		this.peso = peso;
	}


	public String getTipoSanguineo() {
		return tipoSanguineo;
	}


	public void setTipoSanguineo(String tipoSanguineo) throws StringInvalidaException{
		if(tipoSanguineo == null || tipoSanguineo.trim().isEmpty()){
			throw new StringInvalidaException();
		}
		this.tipoSanguineo = tipoSanguineo;
	}


	public String getSexoBiologico() {
		return sexoBiologico;
	}


	public void setSexoBiologico(String sexoBiologico) throws StringInvalidaException{
		if(sexoBiologico == null || sexoBiologico.trim().isEmpty()){
			throw new StringInvalidaException();
		}
		this.sexoBiologico = sexoBiologico;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) throws StringInvalidaException{
		if(genero == null || genero.trim().isEmpty()){
			throw new StringInvalidaException();
		}
		this.genero = genero;
	}
	
	public String toString(){
		String saidaPaciente = "";
		
		saidaPaciente += "Informacoes do paciente" + LINESEPARATOR;
		saidaPaciente += LINESEPARATOR;
		saidaPaciente += "Nome do paciente: " + this.getNomePaciente() + LINESEPARATOR;
		saidaPaciente += "Data de nascimento: " + this.getDataDeNascimento() + LINESEPARATOR;
		saidaPaciente += "Peso: " + this.getPeso() + LINESEPARATOR;
		saidaPaciente += "Tipo Sanguineo: " + this.getTipoSanguineo() + LINESEPARATOR;
		saidaPaciente += "Sexo biologico: " + this.getSexoBiologico() + LINESEPARATOR;
		saidaPaciente += "Genero: " + this.getGenero() + LINESEPARATOR;
		
		return saidaPaciente;
	}
	
	
}
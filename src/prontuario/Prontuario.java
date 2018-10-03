package prontuario;


public class Prontuario implements Comparable<Prontuario>{
	
	private Paciente paciente;
	public static final String LINESEPARATOR = System.lineSeparator();
	
	public Prontuario(Paciente paciente){
		this.paciente = paciente;
	}
		
	public Paciente getPaciente(){
		return this.paciente;
	}
	
	public int compareTo(Prontuario outroProntuario){
		return this.paciente.getNomePaciente().compareTo(outroProntuario.getPaciente().getNomePaciente());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prontuario other = (Prontuario) obj;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		return true;
	}
	
	public String getInfoPaciente(String atributo){
		return getPaciente().getInfoPaciente(atributo);
	}
	
	public String toString(){
		String impressao = "Prontuario do Paciente: " + LINESEPARATOR;
		impressao += this.paciente.toString();
		
		return impressao;
	}
}
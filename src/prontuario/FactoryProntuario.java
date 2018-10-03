package prontuario;

public class FactoryProntuario {
	
	public Prontuario criaProntuario(Paciente paciente){
		return new Prontuario(paciente);
	}

}

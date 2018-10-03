package prontuario;

import java.time.LocalDate;


/**
 * Classe que cria o paciente a ser cadastrado no sistema
 * @author alice
 *
 */
public class FactoryPacientes {
	
	public Paciente criaPacientes(String nome, String dataNascimento, 
			double peso, String tipoSanguineo, String sexoBiologico, String genero) 
					{
		return new Paciente(nome, dataNascimento, peso, tipoSanguineo, sexoBiologico, genero);
	}

}
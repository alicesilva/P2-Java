package usuariosdosistema;

public class FactoryUsuarios {
	
	public Usuario criaUsuario(String nome, String dataDeNascimento, String senha, String matricula, String cargo){
		if(cargo.equals("Tecnico Administrativo")){
			return criaTecnico(nome, dataDeNascimento, senha, matricula, cargo);
		}else if(cargo.equals("Medico")){
			return criaMedico(nome, dataDeNascimento, senha, matricula, cargo);
		}else if (cargo.equals("Diretor Geral")){
			return criaDiretor(nome, dataDeNascimento, senha, matricula, cargo);
		}
		return null;
	}
		
	private Usuario criaTecnico(String nome, String dataDeNascimento, String matricula, String senha, String cargo){
		return new TecnicoAdministrativo(nome, dataDeNascimento, matricula, senha, cargo);		
	}
			
	private Usuario criaMedico(String nome, String dataDeNascimento, String matricula, String senha, String cargo){
		return new Medico(nome, dataDeNascimento, matricula, senha, cargo);
	}
			
	private Usuario criaDiretor(String nome, String dataDeNascimento, String matricula, String senha, String cargo){
		return new DiretorGeral(nome, dataDeNascimento, matricula, senha, cargo);
	}

}

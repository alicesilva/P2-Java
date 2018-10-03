package utilexception;

import java.time.LocalDate;

import exception.CadastroFuncionarioException;

public class VerificadorDeCastro {
	
		
		public void nomeFuncionario(String nome) throws CadastroFuncionarioException{
			if (nome == null || nome.trim().isEmpty()) {
				throw new CadastroFuncionarioException(" Nome do funcionario nao pode ser vazio.");
			}
		}
		
		public void cargoFuncionario(String cargo) throws CadastroFuncionarioException{
			if (cargo == null || cargo.trim().isEmpty()) {
				throw new CadastroFuncionarioException(" Nome do cargo nao pode ser vazio.");
			}
		}
		
		public void dataInvalida(String data) throws CadastroFuncionarioException{
			try {
				String[] valores = data.split("/");
				LocalDate ano = LocalDate.of(Integer.parseInt(valores[2]), Integer.parseInt(valores[1]),Integer.parseInt(valores[0]));
			} catch (Exception e) {
				throw new CadastroFuncionarioException(" Data invalida.");
			}
			
		}
		
		public void existeCargo(String cargo) throws CadastroFuncionarioException{
			if ( !cargo.equals("Medico") && !cargo.equals("Tecnico Administrativo") && !cargo.equals("Diretor Geral")) {
				throw new CadastroFuncionarioException(" Cargo invalido.");
			}
		}
				
		public void diretorCadastrado(String cargo, int qntCadastrada) throws CadastroFuncionarioException{
			if(qntCadastrada > 0 && cargo.equals("Diretor Geral")){
				throw new CadastroFuncionarioException(" Nao eh possivel criar mais de um Diretor Geral.");
			}
		}

	

}

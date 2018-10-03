package usuariosdosistema;

public class DiretorGeral extends Usuario{
	
	public DiretorGeral(String nome, String dataDeNascimento, String matricula, String senha, String cargo){
		super(nome, dataDeNascimento, matricula, senha, cargo);
		addPermissao();
	}
	
	public void addPermissao(){
		
		permissao.add(Funcionalidades.CadastrarFuncionario);
		permissao.add(Funcionalidades.AtualizaDados);
		permissao.add(Funcionalidades.GetInfoFuncionario);
		permissao.add(Funcionalidades.AtualizaInfoFuncionario);
		permissao.add(Funcionalidades.AtualizaSenha);
		permissao.add(Funcionalidades.ExcluiFuncionario);
		permissao.add(Funcionalidades.CadastraPaciente);
		permissao.add(Funcionalidades.GetInfoPaciente);
		permissao.add(Funcionalidades.CadastraMedicamento);
		permissao.add(Funcionalidades.GetInfoMedicamento);
		permissao.add(Funcionalidades.ConsultaMedCategoria);
		permissao.add(Funcionalidades.ConsultaMedNome);
		permissao.add(Funcionalidades.GetEstoqueFarmacia);

	}

}

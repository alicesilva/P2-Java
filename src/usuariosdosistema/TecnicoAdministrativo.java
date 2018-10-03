package usuariosdosistema;


public class TecnicoAdministrativo extends Usuario{
	
		
	public TecnicoAdministrativo(String nome, String dataDeNascimento, String matricula, String senha, String cargo){
		super(nome, dataDeNascimento, matricula, senha, cargo);
		addPermissao();
	}
	
	public void addPermissao(){
		
		permissao.add(Funcionalidades.AtualizaSenha);
		permissao.add(Funcionalidades.CadastraPaciente);
		permissao.add(Funcionalidades.GetInfoPaciente);
		permissao.add(Funcionalidades.CadastraMedicamento);
		permissao.add(Funcionalidades.GetInfoMedicamento);
		permissao.add(Funcionalidades.ConsultaMedCategoria);
		permissao.add(Funcionalidades.ConsultaMedNome);
		permissao.add(Funcionalidades.GetEstoqueFarmacia);
	}
	
	

}

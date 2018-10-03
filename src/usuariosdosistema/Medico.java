package usuariosdosistema;

public class Medico extends Usuario{
	
	public Medico(String nome, String dataDeNascimento, String matricula, String senha, String cargo){
		super(nome, dataDeNascimento, matricula, senha, cargo);
		addPermissao();
	}
	
	public void addPermissao(){
	}
	

}

package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exception.AtualizaFuncionarioException;
import exception.CadastroFuncionarioException;
import exception.CadastroPacienteException;
import exception.ConsultaFuncionarioException;
import exception.ErroLoginException;
import exception.ExcluirFuncionarioException;
import exception.FechaSistemaException;
import exception.LiberaSistemaException;
import exception.LogoutException;
import exception.SOOSException;
import prontuario.FactoryPacientes;
import prontuario.FactoryProntuario;
import prontuario.Paciente;
import prontuario.Prontuario;
import usuariosdosistema.FactoryUsuarios;
import usuariosdosistema.Funcionalidades;
import usuariosdosistema.Usuario;
import utilexception.ValidaLogin;
import utilexception.ValidaPaciente;
import utilexception.VerificadorDeCastro;


public class HospitalController {

	private boolean sistema;
	private Usuario usuarioLogado;
	private static final String CHAVE_SISTEMA = "c041ebf8";
	private int qtdUsuarios;
	private FactoryUsuarios fabricaUsuario;
	private FactoryPacientes fabricaPaciente;
	private FactoryProntuario fabricaProntuario;
	private List<Usuario> funcionarios;
	private List<Prontuario> prontuarios;
	private VerificadorDeCastro verificadorDeCadastro;
	private ValidaPaciente validaPaciente;
	
	private ValidaLogin validaLogin;
	
	public HospitalController(){
		sistema = false;
		fabricaProntuario = new FactoryProntuario();
		fabricaUsuario = new FactoryUsuarios();
		fabricaPaciente = new FactoryPacientes();
		qtdUsuarios = 0;
		funcionarios = new ArrayList<Usuario>();
		prontuarios = new ArrayList<Prontuario>();
		verificadorDeCadastro = new VerificadorDeCastro();
		usuarioLogado = null;
		validaLogin = new ValidaLogin();
		validaPaciente = new ValidaPaciente();
	}
	
	public boolean statusSistema() {
		return sistema;
	}

	public void setSistema(boolean sistema) {
		this.sistema = sistema;
	}
	
	public String liberaSistema(String chave, String nome, String dataNascimento) throws SOOSException {

		if (sistema == true) {
			throw new LiberaSistemaException(" Sistema liberado anteriormente.");
		}
		if (!chave.equals(CHAVE_SISTEMA)) {
			throw new LiberaSistemaException(" Chave invalida.");
		}
		
		sistema = true;
		return cadastraFuncionario(nome, "Diretor Geral", dataNascimento);
		

	}
	
	public void fechaSistema() throws FechaSistemaException{
		if (usuarioLogado != null){
			throw new FechaSistemaException(" Um funcionario ainda esta logado: "+usuarioLogado.getNome()+".");
		}
		sistema = false;
		
	}
	
	private String geraMatricula(String cargo){
		
		int indice = indicePorCargo(cargo);
		int ano = LocalDate.now().getYear();
		String matricula = String.format("%d%d%03d",indice,ano,qtdUsuarios);

		return matricula;
			
	}
	
	private int indicePorCargo(String cargo){
		int indiceCargo = 0;
		
		if (cargo.equals("Diretor Geral")) {
			indiceCargo = 1;
		}else if(cargo.equals("Medico")){
			indiceCargo = 2;
		}else if(cargo.equals("Tecnico Administrativo")){
			indiceCargo = 3;
		}
		
		return indiceCargo;
	}
	
	private String geraSenha(String matricula, String dataNascimento){
		String anoNascimento = dataNascimento.split("/")[2];
		String senha = anoNascimento + matricula.substring(0, 4);
		return senha;
	}
	
	public String cadastraFuncionario(String nome, String cargo, String dataNascimento) throws CadastroFuncionarioException{
				
			verificadorDeCadastro.nomeFuncionario(nome);
			verificadorDeCadastro.cargoFuncionario(cargo);
			verificadorDeCadastro.dataInvalida(dataNascimento);
			verificadorDeCadastro.existeCargo(cargo);
			verificadorDeCadastro.diretorCadastrado(cargo, qtdUsuarios);
			
			qtdUsuarios = qtdUsuarios +1;
			String matricula = geraMatricula(cargo);
			String senha = geraSenha(matricula, dataNascimento);
			dataNascimento = modificaData(dataNascimento);
			Usuario funcionario = fabricaUsuario.criaUsuario(nome, dataNascimento, matricula, senha, cargo);
			funcionarios.add(funcionario);
			
			return matricula;
	
	}
		
	private Usuario getUsuario(String matricula){
		
		for (Usuario usuario : funcionarios) {
			String matriculaUsuario = usuario.getMatricula();
			if (matriculaUsuario.equals(matricula)){
				
				return usuario;
			}
		}
		return null;
		
	}

	public void login(String matricula, String senha) throws ErroLoginException{
		
		if(usuarioLogado != null){
			throw new ErroLoginException(" Um funcionario ainda esta logado: "+ usuarioLogado.getNome() +".");
		}		
		Usuario funcionario = getUsuario(matricula);

		if(funcionario == null){
		 
			throw new ErroLoginException(" Funcionario nao cadastrado.");
		} 
		if(!funcionario.getSenha().equals(senha)){
			throw new ErroLoginException(" Senha incorreta.");
		} 
		
		usuarioLogado = funcionario;
		
	}
	
	public void logout() throws LogoutException{
		if(usuarioLogado == null){
			throw new LogoutException(" Nao ha um funcionario logado.");
		}
		usuarioLogado = null;
	}
		
	public String getInfoFuncionario(String matricula, String atributo) throws ConsultaFuncionarioException{
		
			if(!validaLogin.validaMatricula(matricula)){
				throw new ConsultaFuncionarioException(" A matricula nao segue o padrao.");
			}
					
			Usuario funcionario = getUsuario(matricula);
			if(funcionario == null){
				throw new ConsultaFuncionarioException(" Funcionario nao cadastrado.");
			}
			
			if(atributo.equals("Nome")){
				return funcionario.getNome();
			}else if(atributo.equals("Data")){
				return funcionario.getDataDeNascimento();
			}else if(atributo.equals("Cargo")){
				return funcionario.getCargo();
			}else if(atributo.equals("Senha")){
				throw new ConsultaFuncionarioException(" A senha do funcionario eh protegida.");
			}
			
		return "";
		
	}
	
	private String modificaData(String dataNascimento){
		String[] data = dataNascimento.split("/");
		String anoFormatado = String.format("%s-%s-%s", data[2],data[1],data[0] );
		
		return anoFormatado;
	}

	public void excluiFuncionario(String matricula, String senha) throws ExcluirFuncionarioException{
		if(!validaLogin.validaMatricula(matricula)){
			throw new ExcluirFuncionarioException(" A matricula nao segue o padrao.");
		}
		
		Usuario funcionario = getUsuario(matricula);
		if(funcionario == null){
			throw new ExcluirFuncionarioException(" Funcionario nao cadastrado.");
		}
		if(!funcionario.getSenha().equals(senha)){
			throw new ExcluirFuncionarioException(" Senha invalida.");
		}
		funcionarios.remove(funcionario);
			
	}

	public void atualizaInfoFuncionario(String matricula, String atributo, String novoValor) throws SOOSException{
		Usuario funcionario = getUsuario(matricula);
		if(atributo.equals("Nome")){
			try {
				verificadorDeCadastro.nomeFuncionario(novoValor);
				funcionario.setNome(novoValor);	
			} catch (SOOSException e) {
				throw new AtualizaFuncionarioException(" Nome do funcionario nao pode ser vazio.");
			}	
					
		}else if(atributo.equals("Data")){
			try {
				verificadorDeCadastro.dataInvalida(novoValor);
				novoValor = modificaData(novoValor);
				funcionario.setDataDeNascimento(novoValor);
				
			} catch (CadastroFuncionarioException e) {
				throw new AtualizaFuncionarioException(" Data invalida.");
			}
		}
				
	}
	
	public void atualizaSenha(String senhaAntiga, String senhaNova) throws AtualizaFuncionarioException{
						
		if(!usuarioLogado.getSenha().equals(senhaAntiga)){
			throw new AtualizaFuncionarioException(" Senha invalida.");
		}
		if(!validaLogin.validaSenha(senhaNova)){
			throw new AtualizaFuncionarioException(" A nova senha deve ter entre 8 - 12 caracteres alfanumericos.");
		}
		usuarioLogado.setSenha(senhaNova);
					
	}

	public void atualizaInfoFuncionario(String atributo, String novoValor) throws SOOSException{
		
		if(atributo.equals("Nome")){
			try {
				verificadorDeCadastro.nomeFuncionario(novoValor);
				usuarioLogado.setNome(novoValor);
			} catch (CadastroFuncionarioException e) {
				throw new AtualizaFuncionarioException(" Nome do funcionario nao pode ser vazio.");
			}			
		}else if(atributo.equals("Data")){
			try {
				verificadorDeCadastro.dataInvalida(novoValor);
				novoValor = modificaData(novoValor);
				usuarioLogado.setDataDeNascimento(novoValor);
				
			} catch (CadastroFuncionarioException e) {
				throw new AtualizaFuncionarioException(" Data invalida.");
			}
		}
					
	}

	public void cadastraPaciente( String nome, String dataNascimento, double peso, String sexo, 
			String  genero, String tipoSanguineo) throws CadastroPacienteException{
		
		validaPaciente.nomePaciente(nome);
		validaPaciente.dataInvalida(dataNascimento);
		validaPaciente.pesoPaciente(peso);
		validaPaciente.tipoSanguinio(tipoSanguineo);
		validaPaciente.pacienteCadastrado(existePaciente(nome));
		
		dataNascimento = modificaData(dataNascimento);
		Paciente paciente = fabricaPaciente.criaPacientes(nome, dataNascimento, peso, tipoSanguineo, sexo, genero);
		Prontuario protuarioDoPaciente = criaProntuarioDoPaciente(paciente);
		prontuarios.add(protuarioDoPaciente);
		
	}
	
	private boolean existePaciente(String nome){
		for (Prontuario prontuario : prontuarios) {
			Paciente pacienteAtual = prontuario.getPaciente();
			if (pacienteAtual.getNomePaciente().equals(nome)) {
				return true;
			}
		}
		return false;
	}
	
	private Paciente getPaciente(String nome){
		for (Prontuario prontuario : prontuarios) {
			Paciente pacienteAtual = prontuario.getPaciente();
			if (pacienteAtual.getNomePaciente().equals(nome)) {
				return pacienteAtual;
			}
		}
		return null;
	}
	
	private Prontuario criaProntuarioDoPaciente(Paciente paciente){
		return fabricaProntuario.criaProntuario(paciente);

	}
	
	public String getInfoPaciente(String nome, String atributo){
		Paciente paciente = getPaciente(nome);
		
		if ("Nome".equals(atributo)) {
			return paciente.getNomePaciente();
		}else if ("Data".equals(atributo)) {
			return paciente.getDataDeNascimento();			
		}else if ("Sexo".equals(atributo)) {
			return paciente.getSexoBiologico();			
		}else if ("Genero".equals(atributo)) {
			return paciente.getGenero();			
		}else if ("TipoSanguineo".equals(atributo)) {
			return paciente.getTipoSanguineo();			
		}else if ("Peso".equals(atributo)) {
			String peso = Double.toString(paciente.getPeso());
			return peso;			
		}		
		
		
		return null;
	}
	
}

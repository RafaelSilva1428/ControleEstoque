package servico;

import dao.LoginDAO;
import java.util.Random;
import modelo.Funcionario;
import org.apache.commons.mail.EmailException;
import util.CriptografarSenha;
import util.EnviarEmail;
import util.GerarCodigoAleatorio;

public class ServicoLogin {
    LoginDAO loginDAO = new LoginDAO();
    ServicoFuncionario servicoFuncionario = new ServicoFuncionario();
    
    public boolean verificarLogin(String email, String senha){
        Funcionario func = buscarFuncionario(email);
        
        if(func != null){
            if(func.getEmail().equals(email)){
                String senhaCriptografada = CriptografarSenha.criptografar(senha);
                if(func.getSenha().equals(senhaCriptografada)){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
        
    }
    
    private Funcionario buscarFuncionario(String email){
        Funcionario func = loginDAO.buscarFuncionarioEmail(email);
        if(func != null){
            return func;
        }else{
            return null;
        }
    }
    
    public boolean recuperarSenhaFuncionario(String email){
        Funcionario func = buscarFuncionario(email);
        if(func != null){
            String codigoVerificacao = gerarCodigoSenhaTemporaria();
            
            boolean atualizarSenha = atualizarSenhaSolicitadaPorRecuperacaoDeSenha(email, codigoVerificacao);
            
            if(atualizarSenha){
                servicoFuncionario.alterarStatusAlteracaoSenhaFuncionario(func.getId());
                String senha = codigoVerificacao;
                String remetente = email;
                String titulo = "Recuperação de senha";
                String msg = "Seu E-mail é: "+email+"\nSua senha temporaria é: "+senha;
                try {
                    EnviarEmail.send(remetente, titulo, msg);
                } catch (EmailException ex) {
                    return false;
                }
            }else{
                return false;
            }
            return true;
            
        }else{
            return false;
        }
    }
    
    public boolean atualizarSenhaSolicitadaPorRecuperacaoDeSenha(String email, String codigoVerificacao){
        Funcionario func = new Funcionario();
        
        String codigoVerificacaoCriptografado = CriptografarSenha.criptografar(codigoVerificacao);
            
        func.setEmail(email);
        func.setSenha(codigoVerificacaoCriptografado);
        
        boolean atualizarSenha = loginDAO.atualizarSenhaFuncionario(func);
        if(atualizarSenha){
            return true;
        }else{
            return false;
        }
    }
    
    public String atualizarSenhaFuncionario(String email, String senha, String novaSenha){
        boolean verificarLogin = verificarLogin(email, senha);
        Funcionario func = new Funcionario();
        
        if(verificarLogin == true){
            String codigoVerificacaoCriptografado = CriptografarSenha.criptografar(novaSenha);
            func.setEmail(email);
            func.setSenha(codigoVerificacaoCriptografado);
            boolean atualizarSenha = loginDAO.atualizarSenhaFuncionario(func);
            if(atualizarSenha){
                return "";
            }else{
                return "erro";
            }
        }else{
            return "incompativel";
        }
    }
    
    private String gerarCodigoSenhaTemporaria(){
        String codigo = GerarCodigoAleatorio.gerar();
        return codigo;
    }
    
}

package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CriptografarSenha {
    
    public static String criptografar(String senha){
        String senhaCriptografada = "";
        
        MessageDigest m ;
        try {
            m = MessageDigest.getInstance("MD5");
            m.update(senha.getBytes(),0,senha.length());
            
            senhaCriptografada = new BigInteger(1,m.digest()).toString(16);
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CriptografarSenha.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return senhaCriptografada;
    }
    
}

package main;

import java.text.ParseException;
import org.apache.commons.mail.EmailException;
import util.ObterNomeSistemaOperacional;
import visual.VisualLogin;

public class Controle_Estoque {

	public static void main(String[] args) throws EmailException, ParseException {
            
            VisualLogin vl = new VisualLogin();
            vl.setVisible(true);
            System.out.println(ObterNomeSistemaOperacional.retornarNome());
            
        }
        
    
}

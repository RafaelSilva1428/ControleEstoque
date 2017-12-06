package util;

public class ObterNomeSistemaOperacional {
    
    public static String retornarNome(){
        String nomeSistema = System.getProperty("os.name");
        return nomeSistema;
    }
    
}

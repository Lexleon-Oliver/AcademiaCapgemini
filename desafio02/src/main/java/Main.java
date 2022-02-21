import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numeroMinimo ;
        boolean temDigito,temMaiuscula,temMinuscula,temCaracterEspecial;
        String maiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minusculas = "abcdefghijklmnopqrstuvwxyz";
        String digitos = "0123456789";
        String especiais = "!@#$%^&*()-+";
        Scanner entrada = new Scanner(System.in);
        System.out.println("Entre com a senha");
        String senha = entrada.next();
        temDigito=testarDigito(senha,digitos);
        temMaiuscula=testarMaiuscula(senha,maiusculas);
        temMinuscula=testarMinuscula(senha,minusculas);
        temCaracterEspecial=testarEspecial(senha,especiais);
        numeroMinimo = calcularNumeroMinimo(temDigito,temMaiuscula,temMinuscula,temCaracterEspecial,senha);
        System.out.println(numeroMinimo);

    }

    private static int calcularNumeroMinimo(boolean temDigito, boolean temMaiuscula, boolean temMinuscula, boolean temCaracterEspecial,String senha) {
        int falta;
        int retorno;
        falta = calcularRequisitosFaltantes(temDigito,temMaiuscula,temMinuscula,temCaracterEspecial);

        if (senha.length()<6){
            int restante = 6 -senha.length();
            if(falta<=restante){
                retorno= restante;
            }else{
                retorno =falta;
            }
        }else{
            retorno = falta;
        }
        return retorno;
    }

    private static int calcularRequisitosFaltantes(boolean temDigito, boolean temMaiuscula, boolean temMinuscula, boolean temCaracterEspecial) {
        int retorno = 0;
        if (!temDigito) {
            retorno = retorno + 1;
        }
        if (!temMaiuscula) {
            retorno = retorno + 1;
        }
        if (!temCaracterEspecial) {
            retorno = retorno + 1;
        }
        if (!temMinuscula) {
            retorno = retorno + 1;
        }
        return retorno;
    }

    private static boolean testarEspecial(String senha, String especiais) {
        boolean retorno = false;
        for (int i=0; i<senha.length();i++){
            String caracter = String.valueOf(senha.charAt(i));
            if (especiais.contains(caracter)){
                retorno = true;
            }
        }
        return retorno;
    }

    private static boolean testarMinuscula(String senha, String minusculas) {
        boolean retorno = false;
        for (int i=0; i<senha.length();i++){
            String caracter = String.valueOf(senha.charAt(i));
            if (minusculas.contains(caracter)){
                retorno = true;
            }
        }
        return retorno;
    }

    private static boolean testarMaiuscula(String senha, String maiusculas) {
        boolean retorno = false;
        for (int i=0; i<senha.length();i++){
            String caracter = String.valueOf(senha.charAt(i));
            if (maiusculas.contains(caracter)){
                retorno = true;
            }
        }
        return retorno;
    }

    private static boolean testarDigito(String senha,String digitos) {
        boolean retorno = false;
        for (int i= 0; i<senha.length();i++){
            String caracter = String.valueOf(senha.charAt(i));
            if (digitos.contains(caracter)){
                retorno = true;
            }
        }
        return retorno;
    }
}

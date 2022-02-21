import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Digite o valor relacionado ao tamanho da escada");
        Scanner tamEscada = new Scanner(System.in);
        try {
            int numDegraus = tamEscada.nextInt();
            montarEscada(numDegraus);
        } catch (Exception erro){
            JOptionPane.showMessageDialog(null, "Informe um número válido", "Valor inválido digitado", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void montarEscada(int numDegraus) {
        for (int i=1; i<=numDegraus; i++){
            String degrau;
            String espacoEscada = "";
            String caracterEscada = "";
            for (int j=1; j<=numDegraus-i; j++){
                espacoEscada = espacoEscada + " ";
            }
            for (int k=1; k<=i; k++){
                caracterEscada = caracterEscada+"*";
            }
            degrau = espacoEscada + caracterEscada;
            System.out.println(degrau);
        }
    }
}

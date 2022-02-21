import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numeroAnagramas =0;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Entre com palavra para verificar anagramas");
        String palavraDigitada = entrada.next();
        String palavraMinuscula = palavraDigitada.toLowerCase();
        char[] palavraTemp = palavraMinuscula.toCharArray();
//        numeroAnagramas= numeroAnagramas+testarLetras(palavraTemp);
        numeroAnagramas= numeroAnagramas+testarPalavras(palavraTemp);
        System.out.println(numeroAnagramas);
    }

    private static int testarPalavras(char[] palavraTemp) {
        int retorno=0;
        int tamMax = (palavraTemp.length/2)+1;
        String palavraDigitada = new String(palavraTemp);
        Arrays.sort(palavraTemp);
        String palavraOrdenada = new String(palavraTemp);
        do {
            for (int i=0;i<palavraTemp.length;i++) {
                if (i+tamMax<=palavraTemp.length){
                    char[] charSubPalavra = palavraDigitada.substring(i, i + tamMax).toCharArray();
                    Arrays.sort(charSubPalavra);
                    String subPalavra = new String(charSubPalavra);
                    for(int j=i+1;j<palavraTemp.length;j++){
                        if (j+tamMax<=palavraTemp.length){
                            char[] charSubPalavra2 = palavraDigitada.substring(j, j + tamMax).toCharArray();
                            Arrays.sort(charSubPalavra2);
                            String subPalavra2 = new String(charSubPalavra2);
                            if(subPalavra2.contains(subPalavra)){
                                retorno = retorno+1;
                            }
                        }

                    }
                }else {
                        tamMax=tamMax-1;
                        i=-1;
                }

            }
            tamMax=tamMax-1;
        }while (tamMax>0);

        return retorno;
    }

    private static int testarLetras(char[] palavraTemp) {
        int retorno=0;
        for (int i=0; i<palavraTemp.length;i++){
            char letra = palavraTemp[i];
            for(int j=i+1;j< palavraTemp.length;j++){
                if (letra == palavraTemp[j]) {
                    retorno = retorno+1;
                }
            }
        }
        return retorno;
    }
}

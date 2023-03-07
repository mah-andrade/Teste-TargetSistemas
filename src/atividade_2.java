/*2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.

IMPORTANTE:
Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser previamente definido no código;
*/
public class atividade_2 {
    static int t1= 0,t2= 1,nSequencia = 999999999;
    public static void main(String[] args) {

        Integer NUMERODESEJADO = 34 ;
        Integer auxTrue =0;
        //  0 1 1 2 3 5 8 13
        for(int i = 0; i <nSequencia; i++){
            System.out.println(t2);
            int aux;
            if(t2 ==NUMERODESEJADO){
                auxTrue =1;
            }
            aux = t2;
            t2 = t2+t1;
            t1 = aux;
            if(t1 > NUMERODESEJADO){
                i = nSequencia;
            }
        }
        if(auxTrue == 1){
            System.out.println("o Numero "+NUMERODESEJADO+" faz parte da sequencia");
        }else
        System.out.println("o Numero "+NUMERODESEJADO+" nao faz parte da sequencia");
    }
}

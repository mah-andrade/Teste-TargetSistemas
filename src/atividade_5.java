/*5) Escreva um programa que inverta os caracteres de um string.

IMPORTANTE:
a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
b) Evite usar funções prontas, como, por exemplo, reverse;*/
public class atividade_5 {
    public static void main(String[] args) {

    String nomeCanditado= "Matheus Andrade dos Santos APROVADO";
    String auxInverter = "";
    char [] nomeChar = nomeCanditado.toCharArray();

        for(Integer aux = nomeCanditado.length(); aux > 0; aux--){
            auxInverter = auxInverter + nomeChar[aux-1];
        }
        System.out.println("NOME NORMAL EH: "+ nomeCanditado);
        System.out.println("NOME INVERTIDO EH: "+ auxInverter);
    }
}

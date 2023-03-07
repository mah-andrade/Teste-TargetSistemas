/*4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:

SP – R$67.836,43
RJ – R$36.678,66
MG – R$29.229,88
ES – R$27.165,48
Outros – R$19.849,53
Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.*/

//exercicio simples , mais poderia ter mais detalhes se gostaria que formatasse os numeros em percentual , fiz de forma bruta
public class atividade_4 {
     static final double SP = 67836.43;
    static final double RJ = 36678.66;
    static final double MG = 29229.88;
    static final double ES = 27165.48;
    static final double OUTROS = 19849.53 ;
    static double total;
    public static void main(String[] args) {
        double PORCETAGEM_TOTAL = 0;
        total = SP+RJ+MG+ES+OUTROS;
        String[] cidadesvalores = {String.valueOf(SP), String.valueOf(RJ), String.valueOf(MG), String.valueOf(ES), String.valueOf(OUTROS)};
        String[] cidadesString = {"SP","RJ","MG","ES","Outros"};

        for (Integer aux = 0; aux < cidadesvalores.length;aux++){
            System.out.println(cidadesString[aux]+" TEM O PERCENTUAL DE: "+ calcula_percentual(Double.parseDouble(cidadesvalores[aux])));
            PORCETAGEM_TOTAL = PORCETAGEM_TOTAL + calcula_percentual(Double.parseDouble(cidadesvalores[aux]));
        }

        System.out.println(""+ PORCETAGEM_TOTAL);
    }
    public static double calcula_percentual(double valor){
        valor = (valor*100)/total;
        return valor;
    }
}
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;




/*3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
• O menor valor de faturamento ocorrido em um dia do mês;
• O maior valor de faturamento ocorrido em um dia do mês;
• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

IMPORTANTE:
a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;
* */
public class atividade_3 {
    static ArrayList<Double> valores = new ArrayList<>();
    static ArrayList<Integer> dias = new ArrayList<>();
    static double mediafaturamento;
    static DecimalFormat decimalFormat = new DecimalFormat(".##");
    public static void main(String[] args) {

        JSONParser parser  = new JSONParser();

        try{
            FileReader reader = new FileReader("dados.json");
            Object obj = parser.parse(reader);
            JSONArray rendimentoslista = (JSONArray) obj;
            rendimentoslista.forEach(separator -> parserRend((JSONObject) separator));

                //EXECUTANDO E CHAMANDO AS FUNCOES //

                System.out.println(media_faturamento());
                System.out.println(resultadosdefaturamento());
                System.out.println("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal eh: "+fatudiario_maiorqueamedia());


        } catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }

    private static  void parserRend(JSONObject objetosSeparados){
        valores.add((Double) objetosSeparados.get("valor"));
        dias.add(Integer.valueOf(objetosSeparados.get("dia").toString()));
    }
    public static String media_faturamento(){

        int auxMedia = 0;
        double total_faturamento = 0;
        for(int aux = 0 ; aux < valores.size() ; aux++){
            if(valores.get(aux) == 0.0){
                auxMedia++;
            }else{
                total_faturamento = total_faturamento + Double.parseDouble(String.valueOf(valores.get(aux)));
            }
        }
         mediafaturamento = (total_faturamento/(dias.size()-auxMedia));
        return ("O Faturamento Mensal da empresa nesse mes foi : "+ decimalFormat.format(total_faturamento)+" e a media mensal: "+decimalFormat.format(mediafaturamento));
    }
    public static String resultadosdefaturamento(){
        int diamax = 0,diamin = 0;
        double armazenavalormaximo = 0.0;
        double menornumero = valores.get(0);

        for (int aux = 0 ; aux < valores.size(); aux++){
            if(valores.get(aux) != 0.0){
                if(valores.get(aux) > armazenavalormaximo    ){
                    armazenavalormaximo = valores.get(aux);
                    diamax = aux+1;
                }else if (valores.get(aux) <= menornumero){
                    menornumero = valores.get(aux);
                    diamin = aux+1;
                }
            }
        }
        return("O Dia que mais faturou foi o dia: "+diamax+" e o valor faturado no dia foi :"+decimalFormat.format(armazenavalormaximo)+ "\n" +
                "O dia que menos faturou foi o dia: "+ diamin+" e o valor faturado no dia foi : "+decimalFormat.format(menornumero));
    }
    public static Integer fatudiario_maiorqueamedia(){
        int dias = 0;
        for(int aux = 0; aux < valores.size();aux++){ //22683
            if(valores.get(aux) > mediafaturamento){
                dias++;
            }
        }
        return dias;

    }

}

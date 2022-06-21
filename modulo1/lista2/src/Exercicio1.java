import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat deci = new DecimalFormat("0.0");

        String nomeDoProduto = scan.nextLine();
        double valorDoProduto = scan.nextDouble();

        System.out.println("Produto: " + nomeDoProduto);
        System.out.println("Preço R$: " + valorDoProduto);
        System.out.println(" ");
        System.out.println("Promocao: " + nomeDoProduto);
        System.out.println("----------------------");

        //Não consegui lidar com as "sujeiras" do double
        for(int i=1; i<=10; i++) {
            double custoPromo = valorDoProduto * i;
            valorDoProduto *= 0.95;
            System.out.println(i + " x R$ " + deci.format(valorDoProduto) +
                    " = R$ " + deci.format(custoPromo));
        }
    }



}

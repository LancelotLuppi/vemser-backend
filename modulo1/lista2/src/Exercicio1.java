import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat deci = new DecimalFormat("0.0");
        double desconto;
        double custoPromo;

        System.out.println("------------------------------------");
        System.out.println("Informe o nome do produto:");
        String nomeDoProduto = scan.nextLine();
        System.out.println("Informe o valor do produto:");
        double valorDoProduto = scan.nextDouble();

        System.out.println("Produto: " + nomeDoProduto);
        System.out.println("Preço R$: " + valorDoProduto);
        System.out.println(" ");
        System.out.println("Promocao: " + nomeDoProduto);
        System.out.println("----------------------Tabela de descontos");

        for(int i=0; i<10; i++) {
            desconto = valorDoProduto * (0.95 - 0.05*i);
            custoPromo = desconto *  (i+1);
            System.out.println(i+1 + " x R$ " + deci.format(desconto) +
                    " = R$ " + deci.format(custoPromo));
        }
    }



}

import java.math.BigDecimal;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o valor consumido: ");
        BigDecimal valorConsumido = scanner.nextBigDecimal();
        scanner.nextLine();

        System.out.println("Informe o valor pago: ");
        BigDecimal valorPago = scanner.nextBigDecimal();

        if(valorConsumido.compareTo(valorPago) == 1) {
            System.out.println("O valor pago deve ser maior ou igual ao valo consumido.");
        }
        if(valorConsumido.compareTo(valorPago) == 0 || valorConsumido.compareTo(valorPago) == -1){
            BigDecimal troco = valorPago.subtract(valorConsumido);
            System.out.println("O seu troco eh de " + troco);
        }
    }
}

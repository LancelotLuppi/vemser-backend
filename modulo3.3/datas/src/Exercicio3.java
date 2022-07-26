import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exercicio3 {
    public static void main(String[] args) {
        LocalDateTime data = LocalDateTime.now();
        data = data.plusDays(15).plusHours(10);

        System.out.println("Data apos 15 dias e 10 horas: \n" + data.format(DateTimeFormatter.ofPattern("EEEE - dd MMMM, yyyy")));
        System.out.println("Dia corrido do ano: " + data.getDayOfYear());

    }
}

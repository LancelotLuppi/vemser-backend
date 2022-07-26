import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Exercicio4 {
    public static void main(String[] args) {
        LocalDateTime dataAtual = LocalDateTime.now().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();
        LocalDateTime dataShow = LocalDateTime.of(2024, 9, 14, 18, 30, 0)
                .atZone(ZoneId.of("Europe/London")).toLocalDateTime();

        long diferencaAnos = ChronoUnit.YEARS.between(dataAtual, dataShow);
        dataAtual = dataAtual.plusYears(diferencaAnos);
        long diferencaMeses = ChronoUnit.MONTHS.between(dataAtual, dataShow);
        dataAtual = dataAtual.plusMonths(diferencaMeses);
        long diferencaDias = ChronoUnit.DAYS.between(dataAtual, dataShow);
        dataAtual = dataAtual.plusDays(diferencaDias);
        long diferencaHoras = ChronoUnit.HOURS.between(dataAtual, dataShow);
        dataAtual = dataAtual.plusHours(diferencaHoras);
        long diferencaMinutos = ChronoUnit.MINUTES.between(dataAtual, dataShow);
        dataAtual = dataAtual.plusMinutes(diferencaMinutos);
        long diferencaSegundos = ChronoUnit.SECONDS.between(dataAtual, dataShow);


        System.out.println("Tempo ate o show: \n" +
                diferencaAnos + " anos, \n" +
                diferencaMeses + " meses, \n" +
                diferencaDias + " dias, \n" +
                diferencaHoras + " horas, \n" +
                diferencaMinutos + " minutos e \n" +
                diferencaSegundos + " segundos!");
    }
}

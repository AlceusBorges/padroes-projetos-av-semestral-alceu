import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Observer - Observador concreto: registra todos os lances aceitos com data e hora
public class Auditor implements Observador {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final List<String> registros = new ArrayList<>();

    @Override
    public void atualizar(Lote lote, Lance lance) {
        String dataHora = LocalDateTime.now().format(FORMATO);
        registros.add(String.format("%s | %s | %s | R$ %.2f",
                dataHora, lote.getNome(), lance.getParticipante(), lance.getValor()));
    }

    public void imprimirRegistros() {
        System.out.println("--- Registros do auditor (" + registros.size() + " lances aceitos) ---");
        for (String registro : registros) {
            System.out.println(registro);
        }
    }
}

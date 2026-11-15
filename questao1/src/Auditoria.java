import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Singleton - historico unico de auditoria
public class Auditoria {
    private static Auditoria instancia;

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final List<String> registros = new ArrayList<>();

    private Auditoria() {
    }

    public static synchronized Auditoria getInstancia() {
        if (instancia == null) {
            instancia = new Auditoria();
        }
        return instancia;
    }

    // synchronized: uma thread por vez grava na lista, entao nenhum registro se perde
    public synchronized void registrar(String ambiente, String provedor, String resultado) {
        String dataHora = LocalDateTime.now().format(FORMATO);
        registros.add(dataHora + " | " + ambiente + " | " + provedor + " | " + resultado);
    }

    public void imprimirHistorico() {
        System.out.println("=== Historico de auditoria (" + registros.size() + " registros) ===");
        for (String registro : registros) {
            System.out.println(registro);
        }
    }
}

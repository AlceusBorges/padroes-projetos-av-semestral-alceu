import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Singleton - le o config.properties uma unica vez
public class Configuracao {
    private static Configuracao instancia;

    private final String regiaoPadrao;
    private final double orcamentoMaximo;

    private Configuracao() {
        Properties props = new Properties();
        try (InputStream arquivo = Configuracao.class.getResourceAsStream("/config.properties")) {
            props.load(arquivo);
        } catch (IOException e) {
            throw new IllegalStateException("Erro ao ler config.properties", e);
        }
        this.regiaoPadrao = props.getProperty("regiao.padrao");
        this.orcamentoMaximo = Double.parseDouble(props.getProperty("orcamento.mensal.maximo"));
        System.out.println("[Configuracao] config.properties lido\n");
    }

    // synchronized: se duas threads chegarem juntas, so uma cria a instancia
    public static synchronized Configuracao getInstancia() {
        if (instancia == null) {
            instancia = new Configuracao();
        }
        return instancia;
    }

    public String getRegiaoPadrao() {
        return regiaoPadrao;
    }

    public double getOrcamentoMaximo() {
        return orcamentoMaximo;
    }
}

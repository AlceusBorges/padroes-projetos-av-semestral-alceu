import java.util.concurrent.atomic.AtomicInteger;

// Abstract Factory - Produto concreto (familia Azure)
public class FilaAzure implements Fila {
    public static final double CUSTO_FIXO = 0.50;

    private static final AtomicInteger sequencia = new AtomicInteger();

    private final String id;

    public FilaAzure() {
        this.id = "sb-" + sequencia.incrementAndGet();
    }

    @Override
    public String getId() {
        return id;
    }
}

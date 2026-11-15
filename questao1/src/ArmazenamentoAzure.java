import java.util.concurrent.atomic.AtomicInteger;

// Abstract Factory - Produto concreto (familia Azure)
public class ArmazenamentoAzure implements Armazenamento {
    public static final double CUSTO_POR_GB = 0.02;

    private static final AtomicInteger sequencia = new AtomicInteger();

    private final String id;

    public ArmazenamentoAzure() {
        this.id = "blob://" + sequencia.incrementAndGet();
    }

    @Override
    public String getId() {
        return id;
    }
}

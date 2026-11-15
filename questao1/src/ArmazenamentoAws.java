import java.util.concurrent.atomic.AtomicInteger;

// Abstract Factory - Produto concreto (familia Aws)
public class ArmazenamentoAws implements Armazenamento {
    public static final double CUSTO_POR_GB = 0.023;

    private static final AtomicInteger sequencia = new AtomicInteger();

    private final String id;

    public ArmazenamentoAws() {
        this.id = "s3://" + sequencia.incrementAndGet();
    }

    @Override
    public String getId() {
        return id;
    }
}

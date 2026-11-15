import java.util.concurrent.atomic.AtomicInteger;

// Abstract Factory - Produto concreto (familia Aws)
public class FilaAws implements Fila {
    public static final double CUSTO_FIXO = 0.40;

    private static final AtomicInteger sequencia = new AtomicInteger();

    private final String id;

    public FilaAws() {
        this.id = "sqs-" + sequencia.incrementAndGet();
    }

    @Override
    public String getId() {
        return id;
    }
}

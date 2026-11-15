import java.util.concurrent.atomic.AtomicInteger;

// Abstract Factory - Produto concreto (familia Aws)
public class MaquinaVirtualAws implements MaquinaVirtual {
    public static final double CUSTO_POR_HORA = 0.10;

    // AtomicInteger: evita numero repetido entre threads
    private static final AtomicInteger sequencia = new AtomicInteger();

    private final String id;

    public MaquinaVirtualAws() {
        this.id = "i-" + sequencia.incrementAndGet();
    }

    @Override
    public String getId() {
        return id;
    }
}

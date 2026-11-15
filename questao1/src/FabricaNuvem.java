// Abstract Factory - Fabrica abstrata
public interface FabricaNuvem {
    String getNomeProvedor();

    MaquinaVirtual criarMaquinaVirtual();
    Armazenamento criarArmazenamento();
    Fila criarFila();

    double getCustoVmPorHora();
    double getCustoArmazenamentoPorGb();
    double getCustoFixoFila();
}

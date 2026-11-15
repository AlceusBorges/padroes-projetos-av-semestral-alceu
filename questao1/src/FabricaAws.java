// Abstract Factory - Fabrica concreta: so cria recursos da familia Aws
public class FabricaAws implements FabricaNuvem {

    @Override
    public String getNomeProvedor() {
        return "Aws";
    }

    @Override
    public MaquinaVirtual criarMaquinaVirtual() {
        return new MaquinaVirtualAws();
    }

    @Override
    public Armazenamento criarArmazenamento() {
        return new ArmazenamentoAws();
    }

    @Override
    public Fila criarFila() {
        return new FilaAws();
    }

    @Override
    public double getCustoVmPorHora() {
        return MaquinaVirtualAws.CUSTO_POR_HORA;
    }

    @Override
    public double getCustoArmazenamentoPorGb() {
        return ArmazenamentoAws.CUSTO_POR_GB;
    }

    @Override
    public double getCustoFixoFila() {
        return FilaAws.CUSTO_FIXO;
    }
}

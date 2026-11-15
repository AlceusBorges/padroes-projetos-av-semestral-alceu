import java.util.ArrayList;
import java.util.List;

// Abstract Factory - Cliente: usa apenas as interfaces e recebe a fabrica pronta
public class Provisionador {
    private static final int HORAS_MES = 730;

    private final FabricaNuvem fabrica;

    public Provisionador(FabricaNuvem fabrica) {
        this.fabrica = fabrica;
    }

    public void provisionar(Solicitacao solicitacao) {
        Configuracao config = Configuracao.getInstancia();
        Auditoria auditoria = Auditoria.getInstancia();

        String nome = solicitacao.getNomeAmbiente();
        String provedor = fabrica.getNomeProvedor();

        double custo = solicitacao.getQuantidadeVms() * fabrica.getCustoVmPorHora() * HORAS_MES
                + solicitacao.getGbArmazenamento() * fabrica.getCustoArmazenamentoPorGb()
                + fabrica.getCustoFixoFila();

        if (custo > config.getOrcamentoMaximo()) {
            String motivo = String.format("custo estimado R$ %.2f ultrapassa o orcamento de R$ %.2f",
                    custo, config.getOrcamentoMaximo());
            auditoria.registrar(nome, provedor, "RECUSADO (" + motivo + ")");
            System.out.println("=== Ambiente recusado: " + nome + " (" + motivo + ") ===\n");
            return;
        }

        // Todos os recursos saem da mesma fabrica, logo sao do mesmo provedor
        List<MaquinaVirtual> maquinas = new ArrayList<>();
        for (int i = 0; i < solicitacao.getQuantidadeVms(); i++) {
            maquinas.add(fabrica.criarMaquinaVirtual());
        }
        Armazenamento armazenamento = fabrica.criarArmazenamento();
        Fila fila = fabrica.criarFila();

        Ambiente ambiente = new Ambiente(nome, provedor, config.getRegiaoPadrao(),
                maquinas, armazenamento, fila, custo);

        System.out.println(ambiente.gerarResumo());
        auditoria.registrar(nome, provedor, "ACEITO");
    }
}

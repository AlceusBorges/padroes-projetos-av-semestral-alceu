import java.util.List;

public class Ambiente {
    private final String nome;
    private final String provedor;
    private final String regiao;
    private final List<MaquinaVirtual> maquinas;
    private final Armazenamento armazenamento;
    private final Fila fila;
    private final double custoMensal;

    public Ambiente(String nome, String provedor, String regiao, List<MaquinaVirtual> maquinas,
                    Armazenamento armazenamento, Fila fila, double custoMensal) {
        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
        this.maquinas = maquinas;
        this.armazenamento = armazenamento;
        this.fila = fila;
        this.custoMensal = custoMensal;
    }

    public String gerarResumo() {
        String resumo = "=== Ambiente provisionado: " + nome + " ===\n";
        resumo += "Provedor: " + provedor + "\n";
        resumo += "Regiao: " + regiao + "\n";
        for (MaquinaVirtual vm : maquinas) {
            resumo += "Maquina virtual: " + vm.getId() + "\n";
        }
        resumo += "Armazenamento: " + armazenamento.getId() + "\n";
        resumo += "Fila: " + fila.getId() + "\n";
        resumo += String.format("Custo mensal estimado: R$ %.2f%n", custoMensal);
        return resumo;
    }
}

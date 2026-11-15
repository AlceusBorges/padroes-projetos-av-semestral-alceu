// Decorator - Componente concreto: a fatura sem nenhum servico adicional
public class FaturaBase implements Fatura {
    private final String nomeLote;
    private final double valorVenda;

    public FaturaBase(String nomeLote, double valorVenda) {
        this.nomeLote = nomeLote;
        this.valorVenda = valorVenda;
    }

    @Override
    public double getValorVenda() {
        return valorVenda;
    }

    @Override
    public String getDescricao() {
        return String.format("Lote: %s%nValor de venda: R$ %.2f", nomeLote, valorVenda);
    }

    @Override
    public double getTotal() {
        return valorVenda;
    }
}

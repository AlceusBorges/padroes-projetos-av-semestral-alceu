// Decorator - Decorador abstrato: e uma Fatura e guarda outra Fatura
public abstract class ServicoAdicional implements Fatura {
    protected final Fatura fatura;

    protected ServicoAdicional(Fatura fatura) {
        this.fatura = fatura;
    }

    protected abstract String getNome();
    protected abstract double getCusto();

    @Override
    public double getValorVenda() {
        return fatura.getValorVenda();
    }

    @Override
    public String getDescricao() {
        return fatura.getDescricao() + String.format("%n + %s: R$ %.2f", getNome(), getCusto());
    }

    @Override
    public double getTotal() {
        return fatura.getTotal() + getCusto();
    }
}

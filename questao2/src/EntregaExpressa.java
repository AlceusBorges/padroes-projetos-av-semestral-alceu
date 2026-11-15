// Decorator - Decorador concreto: R$ 450,00 fixos
public class EntregaExpressa extends ServicoAdicional {

    public EntregaExpressa(Fatura fatura) {
        super(fatura);
    }

    @Override
    protected String getNome() {
        return "Entrega expressa";
    }

    @Override
    protected double getCusto() {
        return 450.00;
    }
}

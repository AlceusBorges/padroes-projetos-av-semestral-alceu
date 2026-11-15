// Observer - Observador concreto: mostra o maior lance e o total de lances do lote
public class PainelLeiloeiro implements Observador {

    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.printf("   [PAINEL] '%s': maior lance R$ %.2f | total de lances: %d%n",
                lote.getNome(), lote.getLanceAtual(), lote.getTotalLances());
    }
}

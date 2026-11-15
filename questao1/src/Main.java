public class Main {

    public static void main(String[] args) throws InterruptedException {
        Solicitacao loja = new Solicitacao("loja-virtual", "AWS", 2, 100);
        Solicitacao relatorios = new Solicitacao("relatorios", "AZURE", 1, 50);
        Solicitacao pagamentos = new Solicitacao("pagamentos", "AWS", 3, 200);
        Solicitacao bigData = new Solicitacao("big-data", "AZURE", 20, 500);

        // Dois provisionamentos simultaneos, em threads distintas
        Thread t1 = new Thread(() -> provisionar(loja));
        Thread t2 = new Thread(() -> provisionar(relatorios));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        provisionar(pagamentos);
        provisionar(bigData);

        Auditoria.getInstancia().imprimirHistorico();
    }

    private static void provisionar(Solicitacao solicitacao) {
        FabricaNuvem fabrica = SeletorProvedor.escolher(solicitacao.getProvedor());
        Provisionador provisionador = new Provisionador(fabrica);
        provisionador.provisionar(solicitacao);
    }
}

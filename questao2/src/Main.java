public class Main {

    public static void main(String[] args) {
        Lote quadro = new Lote("Quadro a Oleo", "Arte", 1000.00, 3000.00, new ComissaoArte());
        Lote notebook = new Lote("Notebook Gamer", "Eletronicos", 2000.00, 5000.00, new ComissaoEletronicos());

        Participante ana = new Participante("Ana");
        Participante beto = new Participante("Beto");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        quadro.adicionarObservador(ana);
        quadro.adicionarObservador(beto);
        quadro.adicionarObservador(carla);
        quadro.adicionarObservador(painel);
        quadro.adicionarObservador(auditor);

        notebook.adicionarObservador(ana);
        notebook.adicionarObservador(carla);
        notebook.adicionarObservador(painel);
        notebook.adicionarObservador(auditor);

        System.out.println("========== LOTE 1: Quadro a Oleo (Arte) ==========");
        quadro.darLance(ana.getNome(), 1100.00);
        quadro.darLance(beto.getNome(), 1120.00); // recusado: menos de 5% acima
        quadro.darLance(beto.getNome(), 2000.00);

        System.out.println("\n>> Carla deixa de acompanhar o Quadro a Oleo");
        quadro.removerObservador(carla);
        quadro.darLance(ana.getNome(), 3500.00);

        System.out.println("\n>> Campanha: o Quadro passa a usar a regra de comissao de Eletronicos");
        quadro.setRegraComissao(new ComissaoEletronicos());

        quadro.encerrar();
        quadro.darLance(beto.getNome(), 5000.00); // recusado: lote encerrado
        quadro.imprimirAcerto();

        System.out.println("\n========== LOTE 2: Notebook Gamer (Eletronicos) ==========");
        notebook.darLance(carla.getNome(), 2100.00);
        notebook.darLance(ana.getNome(), 2150.00); // recusado
        notebook.encerrar();
        notebook.imprimirAcerto();

        System.out.println("\n========== FATURA DO COMPRADOR ==========");
        // Decorator: cada servico embrulha a fatura anterior
        Fatura fatura = new FaturaBase(quadro.getNome(), quadro.getLanceAtual());
        fatura = new SeguroTransporte(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new CertificadoAutenticidade(fatura);
        imprimirFatura(fatura);

        System.out.println();
        auditor.imprimirRegistros();
    }

    // Trata qualquer fatura do mesmo jeito, com ou sem servicos
    private static void imprimirFatura(Fatura fatura) {
        System.out.println("--- Fatura ---");
        System.out.println(fatura.getDescricao());
        System.out.printf("TOTAL A PAGAR: R$ %.2f%n", fatura.getTotal());
    }
}

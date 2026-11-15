public class Solicitacao {
    private final String nomeAmbiente;
    private final String provedor;
    private final int quantidadeVms;
    private final int gbArmazenamento;

    public Solicitacao(String nomeAmbiente, String provedor, int quantidadeVms, int gbArmazenamento) {
        this.nomeAmbiente = nomeAmbiente;
        this.provedor = provedor;
        this.quantidadeVms = quantidadeVms;
        this.gbArmazenamento = gbArmazenamento;
    }

    public String getNomeAmbiente() {
        return nomeAmbiente;
    }

    public String getProvedor() {
        return provedor;
    }

    public int getQuantidadeVms() {
        return quantidadeVms;
    }

    public int getGbArmazenamento() {
        return gbArmazenamento;
    }
}

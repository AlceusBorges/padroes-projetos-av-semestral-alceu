public class Lance {
    private final String participante;
    private final double valor;

    public Lance(String participante, double valor) {
        this.participante = participante;
        this.valor = valor;
    }

    public String getParticipante() {
        return participante;
    }

    public double getValor() {
        return valor;
    }
}

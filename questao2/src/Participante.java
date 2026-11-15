// Observer - Observador concreto
public class Participante implements Observador {
    private final String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void atualizar(Lote lote, Lance lance) {
        // Quem deu o lance nao recebe aviso do proprio lance
        if (lance.getParticipante().equals(nome)) {
            return;
        }
        System.out.printf("   [%s] Lote '%s': novo lance de R$ %.2f%n", nome, lote.getNome(), lance.getValor());
    }
}

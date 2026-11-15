import java.util.ArrayList;
import java.util.List;

// Observer - Sujeito concreto: avisa os observadores a cada lance aceito
// Strategy - Contexto: delega o calculo da comissao para a regra vigente
public class Lote implements Sujeito {
    private final String nome;
    private final String categoria;
    private final double precoInicial;
    private final double precoReserva;

    private double lanceAtual;
    private boolean aberto = true;
    private boolean vendido = false;
    private RegraComissao regraComissao;

    private final List<Lance> lances = new ArrayList<>();
    private final List<Observador> observadores = new ArrayList<>();

    public Lote(String nome, String categoria, double precoInicial, double precoReserva,
                RegraComissao regraComissao) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.regraComissao = regraComissao;
    }

    @Override
    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(Lance lance) {
        for (Observador observador : observadores) {
            observador.atualizar(this, lance);
        }
    }

    public void darLance(String participante, double valor) {
        if (!aberto) {
            System.out.printf("LANCE RECUSADO: %s ofereceu R$ %.2f, mas o lote '%s' ja foi encerrado.%n",
                    participante, valor, nome);
            return;
        }
        double minimo = lanceAtual * 1.05;
        if (valor < minimo) {
            System.out.printf("LANCE RECUSADO: %s ofereceu R$ %.2f por '%s', mas o minimo e R$ %.2f.%n",
                    participante, valor, nome, minimo);
            return;
        }
        Lance lance = new Lance(participante, valor);
        lances.add(lance);
        lanceAtual = valor;
        System.out.printf("LANCE ACEITO: %s ofereceu R$ %.2f por '%s'.%n", participante, valor, nome);
        notificarObservadores(lance);
    }

    public void encerrar() {
        aberto = false;
        vendido = !lances.isEmpty() && lanceAtual >= precoReserva;
        if (vendido) {
            System.out.printf("ENCERRADO: '%s' (%s) VENDIDO por R$ %.2f.%n", nome, categoria, lanceAtual);
        } else {
            System.out.printf("ENCERRADO: '%s' (%s) NAO VENDIDO: preco inicial R$ %.2f, maior lance R$ %.2f, reserva R$ %.2f.%n",
                    nome, categoria, precoInicial, lanceAtual, precoReserva);
        }
    }

    // Strategy: troca a regra em tempo de execucao, sem recriar o lote
    public void setRegraComissao(RegraComissao regraComissao) {
        this.regraComissao = regraComissao;
    }

    public void imprimirAcerto() {
        System.out.println("--- Acerto do vendedor: " + nome + " ---");
        if (!vendido) {
            System.out.println("Lote nao vendido: nao ha acerto.");
            return;
        }
        double comissao = regraComissao.calcular(lanceAtual);
        System.out.printf("Valor de venda: R$ %.2f%n", lanceAtual);
        System.out.printf("Comissao (%s): R$ %.2f%n", regraComissao.getDescricao(), comissao);
        System.out.printf("Valor liquido a repassar: R$ %.2f%n", lanceAtual - comissao);
    }

    public String getNome() {
        return nome;
    }

    public double getLanceAtual() {
        return lanceAtual;
    }

    public int getTotalLances() {
        return lances.size();
    }
}

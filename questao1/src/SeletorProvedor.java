// Componente que escolhe o provedor: unico lugar com switch de provedor
public class SeletorProvedor {

    public static FabricaNuvem escolher(String provedor) {
        switch (provedor.toUpperCase()) {
            case "AWS":
                return new FabricaAws();
            case "AZURE":
                return new FabricaAzure();
            default:
                throw new IllegalArgumentException("Provedor desconhecido: " + provedor);
        }
    }
}

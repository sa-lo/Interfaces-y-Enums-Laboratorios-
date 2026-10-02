public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("Camila")
                .agregar(Bebida.CAPUCHINO, Tamaño.GRANDE, 2)
                .agregar(Bebida.TINTO, Tamaño.PEQUENO, 1)
                .agregar(Bebida.CHOCOLATE, Tamaño.MEDIANO, 1);

        pedido.aplicarPromocion(Promocion.porcentaje(10));
        pedido.avanzar();
        pedido.avanzar();
        pedido.imprimirTicket();

        try {
            pedido.cancelar();
        } catch (IllegalStateException e) {
            System.out.println("Aviso: " + e.getMessage());
        }
    }
}

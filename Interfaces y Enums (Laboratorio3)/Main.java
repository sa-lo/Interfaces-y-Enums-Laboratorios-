//Semáforo inteligente

enum Semaforo {
    VERDE(30, "Avance"), AMARILLO(5, "Precaución"), ROJO(35, "Pare");

    private final int segundos;
    private final String accion;

    Semaforo(int segundos, String accion) {
        this.segundos = segundos;
        this.accion = accion;
    }

    public int getSegundos() { return segundos; }
    public String getAccion() { return accion; }

    public Semaforo siguiente() {
        return switch (this) {
            case VERDE -> AMARILLO;
            case AMARILLO -> ROJO;
            case ROJO -> VERDE;
        };
    }

    public static int duracionCiclo() {
        int total = 0;
        for (Semaforo s : values()) total += s.segundos;
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        Semaforo luz = Semaforo.VERDE;
        for (int paso = 1; paso <= 4; paso++) {
            System.out.printf("Paso %d: %-8s %2ds %s%n",
                    paso, luz, luz.getSegundos(), luz.getAccion());
            luz = luz.siguiente();
        }
        System.out.println("Duración del ciclo completo: " + Semaforo.duracionCiclo() + "s");
    }
}
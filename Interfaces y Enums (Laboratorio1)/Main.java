//Mi playlist ordenada

import java.util.*;
import java.util.function.Predicate;

class Cancion implements Comparable<Cancion> {
    private final String titulo;
    private final String artista;
    private final int duracionSeg;

    Cancion(String titulo, String artista, int duracionSeg) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracionSeg = duracionSeg;
    }

    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public int getDuracionSeg() { return duracionSeg; }

    public String duracion() {
        return String.format("%d:%02d", duracionSeg / 60, duracionSeg % 60);
    }

    @Override
    public int compareTo(Cancion otra) { return titulo.compareTo(otra.titulo); }
}

public class Main {
    public static void main(String[] args) {
        List<Cancion> playlist = new ArrayList<>(List.of(
                new Cancion("Tusa", "Karol G", 200),
                new Cancion("La Bicicleta", "Carlos Vives", 227),
                new Cancion("Despacito", "Luis Fonsi", 228),
                new Cancion("Bailando", "Enrique Iglesias", 243)
        ));

        Collections.sort(playlist);
        System.out.println("Orden natural (título):");
        for (Cancion c : playlist) {
            System.out.printf(" %-14s %-17s %s%n", c.getTitulo(), c.getArtista(), c.duracion());
        }

        playlist.sort(Comparator.comparingInt(Cancion::getDuracionSeg).reversed());
        System.out.println("De la más larga a la más corta:");
        playlist.forEach(c -> System.out.println(c.getTitulo() + " (" + c.duracion() + ")"));

        Predicate<Cancion> esLarga = c -> c.getDuracionSeg() > 200;
        List<String> largas = playlist.stream()
                .filter(esLarga)
                .map(c -> c.getTitulo().toUpperCase())
                .toList();
        System.out.println("Canciones largas: " + largas);
    }
}
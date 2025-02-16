package ParqueJurasico;

import java.util.Random;
import java.util.Scanner;

public class ParqueJurasico {
    private static final int TAMANO = 10;
    private static int[] ubicaciones = new int[TAMANO];

    public static void main(String[] args) {
        inicializarUbicaciones();
        menu();
    }

    private static void inicializarUbicaciones() {
        Random random = new Random();
        for (int i = 0; i < TAMANO; i++) {
            ubicaciones[i] = random.nextInt(2); // 0 o 1
        }
    }

    private static void mostrarMapa() {
        System.out.print("Estado actual del recinto: ");
        for (int raptor : ubicaciones) {
            System.out.print((raptor == 1 ? "X" : "-") + " ");
        }
        System.out.println();
    }

    private static void buscarRaptor(int posicion) {
        if (ubicaciones[posicion - 1] == 1) {
            System.out.println("¡Raptor encontrado en la posición " + posicion + "!");
        } else {
            System.out.println("No hay raptor en la posición " + posicion + ".");
        }
    }

    private static void capturarRaptor(int posicion) {
        if (ubicaciones[posicion - 1] == 1) {
            ubicaciones[posicion - 1] = 0;
            System.out.println("¡Raptor capturado en la posición " + posicion + "!");
        } else {
            System.out.println("No hay raptor en la posición " + posicion + " para capturar.");
        }
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Mostrar mapa");
            System.out.println("2. Buscar raptor");
            System.out.println("3. Capturar raptor");
            System.out.println("4. Salir");

            System.out.print("Selecciona una opción (1-4): ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    mostrarMapa();
                    break;
                case "2":
                    System.out.print("Ingresa la posición (1-10) para buscar un raptor: ");
                    try {
                        int posicion = Integer.parseInt(scanner.nextLine());
                        if (posicion >= 1 && posicion <= 10) {
                            buscarRaptor(posicion);
                        } else {
                            System.out.println("Por favor, ingresa un número entre 1 y 10.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada no válida. Por favor, ingresa un número.");
                    }
                    break;
                case "3":
                    System.out.print("Ingresa la posición (1-10) para capturar un raptor: ");
                    try {
                        int posicion = Integer.parseInt(scanner.nextLine());
                        if (posicion >= 1 && posicion <= 10) {
                            capturarRaptor(posicion);
                        } else {
                            System.out.println("Por favor, ingresa un número entre 1 y 10.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada no válida. Por favor, ingresa un número.");
                    }
                    break;
                case "4":
                    System.out.println("Saliendo del programa. ¡Buena suerte en la captura de velociraptores!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción del menú.");
            }
        }
    }
}
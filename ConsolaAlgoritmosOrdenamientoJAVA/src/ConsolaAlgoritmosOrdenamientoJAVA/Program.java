package ConsolaAlgoritmosOrdenamientoJAVA;

import java.util.Arrays;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            // Obtener datos del usuario
            System.out.println("Ingrese los datos separados por comas:");
            int[] data = parseInput(scanner.nextLine());

            // Seleccionar algoritmo
            System.out.println("Seleccione un algoritmo de ordenamiento:");
            System.out.println("1. Shell Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Heap Sort");
            System.out.println("4. Quick Sort");
            System.out.println("5. Bubble Sort");
            System.out.println("6. Cocktail Sort");
            System.out.println("7. Insertion Sort");
            System.out.println("8. Bucket Sort");
            System.out.println("9. Counting Sort");
            System.out.println("10. Merge Sort");
            System.out.println("11. Binary Tree Sort");
            System.out.println("12. Radix Sort");
            System.out.println("13. Gnome Sort");
            System.out.println("14. Natural Merge Sort");

            int choice = Integer.parseInt(scanner.nextLine());

            // Crear una instancia del algoritmo seleccionado
            SortingAlgorithm selectedAlgorithm = getSortingAlgorithm(choice);

            // Medir el tiempo de ejecución
            long startTime = System.currentTimeMillis();

            // Llamar al método de ordenamiento
            selectedAlgorithm.sort(data);

            long endTime = System.currentTimeMillis();
            System.out.println("Tiempo de ejecución: " + (endTime - startTime) + " ms");

            // Mostrar resultados ordenados
            System.out.println("Datos ordenados:");
            System.out.println(Arrays.toString(data));

            // Preguntar al usuario si desea repetir con otro algoritmo
            System.out.println("¿Desea probar otro algoritmo? (Sí/No)");
        } while (scanner.nextLine().trim().equalsIgnoreCase("Sí"));
    }

    static int[] parseInput(String input) {
        // Convierte la entrada del usuario en un array de enteros
        return Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    static SortingAlgorithm getSortingAlgorithm(int choice) {
        // Devuelve una instancia del algoritmo de ordenamiento seleccionado
        switch (choice) {
            case 1:
                return new ShellSort();
            case 2:
                return new SelectionSort();
            case 3:
                return new HeapSort();
            case 4:
                return new QuickSort();
            case 5:
                return new BubbleSort();
            case 6:
                return new CocktailSort();
            case 7:
                return new InsertionSort();
            case 8:
                return new BucketSort();
            case 9:
                return new CountingSort();
            case 10:
                return new MergeSort();
            case 11:
                return new BinaryTreeSort();
            case 12:
                return new RadixSort();
            case 13:
                return new GnomeSort();
            case 14:
                return new NaturalMergeSort();
            default:
                throw new IllegalArgumentException("Opción no válida");
        }
    }
}


package ConsolaAlgoritmosOrdenamientoJAVA;
import java.util.Arrays;

public class CocktailSort implements SortingAlgorithm {
    public void sort(int[] arr) {
        boolean swapped;
        do {
            swapped = false;

            // Mover el elemento más grande al final
            for (int i = 0; i <= arr.length - 2; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    displayStepByStep(arr);
                    swapped = true;
                }
            }

            // Si no hubo intercambios, el array ya está ordenado
            if (!swapped)
                break;

            swapped = false;

            // Mover el elemento más pequeño al inicio
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    displayStepByStep(arr);
                    swapped = true;
                }
            }

        } while (swapped);

        displayStepByStep(arr);
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private void displayStepByStep(int[] arr) {
        System.out.println("Proceso del Cocktail Sort:");
        System.out.println(Arrays.toString(arr));
    }
}


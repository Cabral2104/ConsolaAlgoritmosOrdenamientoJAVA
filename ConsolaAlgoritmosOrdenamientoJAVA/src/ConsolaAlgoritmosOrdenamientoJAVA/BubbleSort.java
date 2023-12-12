package ConsolaAlgoritmosOrdenamientoJAVA;
import java.util.Arrays;

public class BubbleSort implements SortingAlgorithm {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // Comparar elementos adyacentes
                if (arr[j] > arr[j + 1]) {
                    // Intercambiar si el elemento actual es mayor que el siguiente
                    swap(arr, j, j + 1);
                    displayStepByStep(arr);
                }
            }
        }

        displayStepByStep(arr);
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private void displayStepByStep(int[] arr) {
        System.out.println("Proceso del Bubble Sort:");
        System.out.println(Arrays.toString(arr));
    }
}


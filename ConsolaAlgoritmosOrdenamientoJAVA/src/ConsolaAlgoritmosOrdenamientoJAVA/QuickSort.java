package ConsolaAlgoritmosOrdenamientoJAVA;
import java.util.Arrays;

public class QuickSort implements SortingAlgorithm {
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        displayStepByStep(arr);
    }

    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            // Obtener el índice del pivote después de la partición
            int pi = partition(arr, low, high);

            // Ordenar los elementos antes y después del pivote
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // Índice del menor elemento

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arr[j] <= pivot) {
                i++;

                // Intercambiar arr[i] y arr[j]
                swap(arr, i, j);

                displayStepByStep(arr);
            }
        }

        // Intercambiar arr[i + 1] y arr[high] (pivote)
        swap(arr, i + 1, high);

        displayStepByStep(arr);

        return i + 1;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private void displayStepByStep(int[] arr) {
        System.out.println("Proceso del Quick Sort:");
        System.out.println(Arrays.toString(arr));
    }
}


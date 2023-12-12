package ConsolaAlgoritmosOrdenamientoJAVA;
import java.util.Arrays;

public class InsertionSort implements SortingAlgorithm {
    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Mover los elementos del array que son mayores que key
            // a una posición adelante de su posición actual
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
            displayStepByStep(arr);
        }

        displayStepByStep(arr);
    }

    private void displayStepByStep(int[] arr) {
        System.out.println("Proceso del Insertion Sort:");
        System.out.println(Arrays.toString(arr));
    }
}


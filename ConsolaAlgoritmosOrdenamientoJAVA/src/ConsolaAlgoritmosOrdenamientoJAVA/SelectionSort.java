package ConsolaAlgoritmosOrdenamientoJAVA;
import java.util.Arrays;

public class SelectionSort implements SortingAlgorithm {
    public void sort(int[] arr) {
        displayStepByStep(arr);
    }

    private void displayStepByStep(int[] arr) {
        System.out.println("Proceso del Selection Sort:");

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Intercambiar el elemento mínimo con el primero no ordenado
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            System.out.println(Arrays.toString(arr));
        }
    }
}

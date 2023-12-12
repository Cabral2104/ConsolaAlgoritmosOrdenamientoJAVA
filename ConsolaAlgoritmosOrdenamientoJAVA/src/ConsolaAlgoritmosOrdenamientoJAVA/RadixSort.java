package ConsolaAlgoritmosOrdenamientoJAVA;
import java.util.Arrays;

public class RadixSort implements SortingAlgorithm  {
    public void sort(int[] arr) {
        int maxVal = findMaxValue(arr);

        // Realizar el sort para cada posición decimal
        for (int exp = 1; maxVal / exp > 0; exp *= 10) {
            countingSort(arr, exp);
            displayStepByStep(arr);
        }

        displayStepByStep(arr);
    }

    private void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    private int findMaxValue(int[] arr) {
        int max = arr[0];
        for (int item : arr) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }

    private void displayStepByStep(int[] arr) {
        System.out.println("Proceso del Radix Sort:");
        System.out.println(String.join(", ", Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new)));
    }
}


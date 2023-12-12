package ConsolaAlgoritmosOrdenamientoJAVA;
import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {
    public void sort(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        mergeSortRecursive(arr, temp, 0, n - 1);
    }

    private void mergeSortRecursive(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Ordenar recursivamente las dos mitades
            mergeSortRecursive(arr, temp, left, mid);
            mergeSortRecursive(arr, temp, mid + 1, right);

            // Combinar las dos mitades ordenadas
            merge(arr, temp, left, mid, right);
            displayStepByStep(arr);
        }
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

    private void displayStepByStep(int[] arr) {
        System.out.println("Proceso del Merge Sort:");
        System.out.println(Arrays.toString(arr));
    }
}

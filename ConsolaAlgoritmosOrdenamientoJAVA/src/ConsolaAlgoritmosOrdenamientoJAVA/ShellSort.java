package ConsolaAlgoritmosOrdenamientoJAVA;
import java.util.Arrays;

public class ShellSort implements SortingAlgorithm {
    public void sort(int[] arr) {
        displayStepByStep(arr);
    }

    private void displayStepByStep(int[] arr) {
        System.out.println("Proceso del Shell Sort:");

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;

                System.out.println(Arrays.toString(arr));
            }
        }
    }
}


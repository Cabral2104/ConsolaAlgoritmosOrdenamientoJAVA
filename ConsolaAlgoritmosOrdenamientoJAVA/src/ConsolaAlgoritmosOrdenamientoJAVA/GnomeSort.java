package ConsolaAlgoritmosOrdenamientoJAVA;
import java.util.Arrays;

public class GnomeSort implements SortingAlgorithm {
    public void sort(int[] arr) {
        int n = arr.length;
        int index = 0;

        while (index < n) {
            if (index == 0) {
                index++;
            }

            if (arr[index] >= arr[index - 1]) {
                index++;
            } else {
                // Intercambiar elementos y retroceder
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;

                index--;
            }

            displayStepByStep(arr);
        }

        displayStepByStep(arr);
    }

    private void displayStepByStep(int[] arr) {
        System.out.println("Proceso del Gnome Sort:");
        System.out.println(String.join(", ", Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new)));
    }
}


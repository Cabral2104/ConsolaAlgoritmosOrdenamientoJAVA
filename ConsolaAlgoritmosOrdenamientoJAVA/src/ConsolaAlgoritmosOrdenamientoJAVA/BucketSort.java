package ConsolaAlgoritmosOrdenamientoJAVA;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort implements SortingAlgorithm {
    public void sort(int[] arr) {
        int n = arr.length;

        // Encontrar el máximo y mínimo en el array
        int maxVal = Arrays.stream(arr).max().getAsInt();
        int minVal = Arrays.stream(arr).min().getAsInt();

        // Crear los cubos
        @SuppressWarnings("unchecked")
		List<Integer>[] buckets = new ArrayList[maxVal - minVal + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Colocar elementos en los cubos
        for (int i = 0; i < n; i++) {
            buckets[arr[i] - minVal].add(arr[i]);
            displayStepByStep(buckets);
        }

        // Ordenar cada cubo e insertar de nuevo en el array principal
        int index = 0;
        for (List<Integer> bucket : buckets) {
            bucket.sort(null);
            for (int item : bucket) {
                arr[index++] = item;
                displayStepByStep(arr);
            }
        }

        displayStepByStep(arr);
    }

    private void displayStepByStep(List<Integer>[] buckets) {
        System.out.println("Proceso del Bucket Sort:");
        for (List<Integer> bucket : buckets) {
            System.out.print("[");
            System.out.print(String.join(", ", bucket.stream().map(Object::toString).toArray(String[]::new)));
            System.out.print("] ");
        }
        System.out.println();
    }

    private void displayStepByStep(int[] arr) {
        System.out.println("Proceso del Bucket Sort:");
        System.out.println(Arrays.toString(arr));
    }
}


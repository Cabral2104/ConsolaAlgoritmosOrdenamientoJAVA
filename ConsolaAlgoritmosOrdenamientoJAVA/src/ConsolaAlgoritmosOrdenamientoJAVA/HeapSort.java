package ConsolaAlgoritmosOrdenamientoJAVA;
import java.util.Arrays;

public class HeapSort implements SortingAlgorithm {
    public void sort(int[] arr) {
        int n = arr.length;

        // Construir un heap máximo
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extraer elementos del heap uno por uno
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            swap(arr, 0, i);

            // Llamar a heapify en el heap reducido
            heapify(arr, i, 0);

            displayStepByStep(arr);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i; // Inicializar el nodo más grande como la raíz
        int left = 2 * i + 1; // Índice del hijo izquierdo
        int right = 2 * i + 2; // Índice del hijo derecho

        // Si el hijo izquierdo es más grande que la raíz
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Si el hijo derecho es más grande que el nodo más grande hasta ahora
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Si el nodo más grande no es la raíz
        if (largest != i) {
            swap(arr, i, largest);

            // Recursivamente heapify el subárbol afectado
            heapify(arr, n, largest);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private void displayStepByStep(int[] arr) {
        System.out.println("Proceso del Heap Sort:");
        System.out.println(Arrays.toString(arr));
    }
}


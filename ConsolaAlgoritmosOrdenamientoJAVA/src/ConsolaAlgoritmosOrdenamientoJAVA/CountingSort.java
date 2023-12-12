package ConsolaAlgoritmosOrdenamientoJAVA;

import java.util.Arrays;

public class CountingSort implements SortingAlgorithm {
    public void sort(int[] arr) {
        int n = arr.length;

        // Encontrar el valor máximo en el array
        int maxVal = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        // Crear el array de conteo
        int[] count = new int[maxVal + 1];

        // Contar la frecuencia de cada elemento
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
            displayStepByStepCount(count);
        }

        // Reconstruir el array ordenado
        int index = 0;
        for (int i = 0; i <= maxVal; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
                displayStepByStepArray(arr);
            }
        }

        displayStepByStepArray(arr);
    }

    private void displayStepByStepArray(int[] arr) {
        System.out.println("Proceso del Counting Sort:");
        System.out.println(Arrays.toString(arr));
    }

    private void displayStepByStepCount(int[] count) {
        System.out.println("Proceso del Counting Sort:");
        System.out.println(Arrays.toString(count));
    }
}


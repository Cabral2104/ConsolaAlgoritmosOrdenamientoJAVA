package ConsolaAlgoritmosOrdenamientoJAVA;
import java.util.Arrays;

public class NaturalMergeSort implements SortingAlgorithm {
    private int[] arreglo;

    public void sort(int[] arr) {
        arreglo = arr;
        mezclaNatural();
    }

    private void mezclaNatural() {
        int longitud = arreglo.length;
        int izquierda = 0;
        int derecha = 0;
        int mitad = 0;

        while (true) {
            boolean cambio = false;
            izquierda = 0;

            while (izquierda < longitud) {
                mitad = izquierda + 1;

                while (mitad < longitud && arreglo[mitad - 1] <= arreglo[mitad]) {
                    mitad++;
                }

                if (mitad == longitud) {
                    break;
                }

                derecha = mitad + 1;

                while (derecha < longitud && arreglo[derecha - 1] <= arreglo[derecha]) {
                    derecha++;
                }

                merge(izquierda, mitad, derecha);
                cambio = true;

                izquierda = derecha;
            }

            if (!cambio) {
                break;
            }
        }
    }

    private void merge(int izquierda, int mitad, int derecha) {
        System.out.println("Mezclando desde " + izquierda + " hasta " + (derecha - 1));

        int[] temp = new int[derecha - izquierda];
        int i = izquierda;
        int j = mitad;
        int k = 0;

        while (i < mitad && j < derecha) {
            if (arreglo[i] <= arreglo[j]) {
                temp[k++] = arreglo[i++];
            } else {
                temp[k++] = arreglo[j++];
            }
        }

        while (i < mitad) {
            temp[k++] = arreglo[i++];
        }

        while (j < derecha) {
            temp[k++] = arreglo[j++];
        }

        for (int m = 0; m < temp.length; m++) {
            arreglo[izquierda + m] = temp[m];
        }

        mostrarArreglo();
    }

    public void mostrarArreglo() {
        System.out.println(String.join(", ", Arrays.stream(arreglo).mapToObj(String::valueOf).toArray(String[]::new)));
    }
}


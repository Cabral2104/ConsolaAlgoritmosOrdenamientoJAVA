package ConsolaAlgoritmosOrdenamientoJAVA;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class BinaryTreeSort implements SortingAlgorithm {
    private Node root;

    public void sort(int[] arr) {
        int n = arr.length;

        // Construir el árbol binario
        for (int i = 0; i < n; ++i) {
            root = insert(root, arr[i]);
            displayStepByStep(arr[i]);
        }

        // Recorrer el árbol in-order y almacenar los valores en una lista
        List<Integer> sortedList = new ArrayList<>();
        inOrderTraversal(root, sortedList);

        // Copiar la lista ordenada de vuelta al array
        for (int i = 0; i < n; ++i) {
            arr[i] = sortedList.get(i);
            displayStepByStep(arr);
        }
    }

    private Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    private void inOrderTraversal(Node root, List<Integer> sortedList) {
        if (root != null) {
            inOrderTraversal(root.left, sortedList);
            sortedList.add(root.key);
            inOrderTraversal(root.right, sortedList);
        }
    }

    private void displayStepByStep(int value) {
        System.out.println("Insertar " + value + " en el árbol binario:");
        displayTree(root, "");
    }

    private void displayStepByStep(int[] arr) {
        System.out.println("Proceso del Binary Tree Sort:");
        System.out.println(String.join(", ", Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new)));
    }

    private void displayTree(Node root, String prefix) {
        if (root != null) {
            System.out.println(prefix + "└── " + root.key);
            displayTree(root.left, prefix + "    ");
            displayTree(root.right, prefix + "    ");
        }
    }

    private static class Node {
        public int key;
        public Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
}


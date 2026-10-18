import java.util.*;

public class Array {
    private final int[] A;
    private int compares = 0;
    private int swaps = 0;

    public Array(int n, long seed)
    {
        ArrayList<Integer> x=new ArrayList<>(n);
        for (int i=0; i<n; i++) x.add(i);
        Collections.shuffle(x, new Random(seed));
        A = new int[n];
        for (int i=0; i<n; i++) A[i] = x.get(i);
    }

    public int length() {
        return A.length;
    }

    public boolean compare(int i, int j)
    {
        printCompare(i,j);
        compares++;
        return A[i]>A[j];
    }

    public void swap(int i, int j)
    {
        swaps++;
        int x=A[i];
        A[i]=A[j];
        A[j]=x;
        printSwap(i,j);
    }

    private static final String RESET = "\033[0m";
    private static final String RED = "\033[0;31m";
    private static final String GREEN = "\033[0;32m";
    private static final String BLUE = "\033[0;34m";

    private static final String FORMAT = "%3d";

    private void printCompare(int i, int j)
    {
        System.out.print("compare " + RED);
        for (int k = 0; k < A.length; k++) {
            if ((k == i) || (k == j)) System.out.print(BLUE);
            System.out.printf(FORMAT, A[k]);
            if ((k == i) || (k == j)) System.out.print(RESET + RED);
        }
        System.out.println(RESET);
    }

    private void printSwap(int i, int j) {
        System.out.print("swap    " + GREEN);
        for (int k = 0; k < A.length; k++) {
            if ((k == i) || (k == j)) System.out.print(BLUE);
            System.out.printf(FORMAT, A[k]);
            if ((k == i) || (k == j)) System.out.print(RESET + GREEN);
        }
        System.out.println(RESET);
    }

    private int sort(SortingAlgorithm<Array> algorithm) {
        algorithm.sort(this);
        System.out.println("n="+A.length+", compares=" + compares + ", swaps=" + swaps);
        return compares*2 + swaps*4;
    }

    public static void main(String[] args) {
        int n=10, seed=42;
        SortingAlgorithm[] algorithms = {
                new BubbleSort<Array>(),
                new SelectionSort<Array>(),
                new InsertionSort(),
                new ShellSort(),
                new QuickSort(),
                new HeapSort()
        };
        Map<String, Integer> results = new TreeMap<>();
        for (SortingAlgorithm algorithm : algorithms) {
            System.out.println(algorithm.getClass().getSimpleName());
            int operations = new Array(n, seed).sort(algorithm);
            results.put(algorithm.getClass().getSimpleName(), operations);
            System.out.println();
        }
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

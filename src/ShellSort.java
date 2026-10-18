public class ShellSort implements SortingAlgorithm<Array> {

    private static void hSort(Array A, int h) {
        for(int i = h; i < A.length(); i++){
            int j = i;
            while(j >= h && A.compare(j - h, j)){
                A.swap(j - h, j);
                j -= h;
            }
        }
    }

    public void sort(Array A) {
        int n = A.length();
        for (int h = n / 2; h > 0; h /= 2) {
            hSort(A, h);
        }
    }
}

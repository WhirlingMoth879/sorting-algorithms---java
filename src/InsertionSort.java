public class InsertionSort implements SortingAlgorithm<Array> {

    public void sort(Array A)
    {
        for(int i = 0; i < A.length(); i++) {
            int j = i;
            while(j > 0 && A.compare(j - 1, j)) {
                A.swap(j - 1, j);
                j--;
            }
        }
    }

}

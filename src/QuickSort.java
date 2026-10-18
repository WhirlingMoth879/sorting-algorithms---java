public class QuickSort implements SortingAlgorithm<Array> {

    private static int partition(Array A, int p, int r)
    {
        int pivotIndex = r;
        int i = p - 1;
        for(int j = p; j <= r - 1; j++){
            if(A.compare(pivotIndex, j)){
                i++;
                if(i != j) {
                    A.swap(i, j);
                }
            }
        }
        if(i + 1 != r){
            A.swap(i + 1, r);
        }
        return i + 1;
    }

    private static void quicksort(Array A, int p, int r)
    {
        if(p < r){
            int pi = partition(A, p, r);
            quicksort(A, p, pi - 1);
            quicksort(A, pi + 1, r);
        }
    }

    public void sort(Array A) {
        quicksort(A, 0, A.length()-1);
    }
}

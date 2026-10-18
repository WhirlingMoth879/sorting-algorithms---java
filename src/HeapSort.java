public class HeapSort implements SortingAlgorithm<Array> {

    private static void heapify(Array A, int i, int h) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if(leftChild < h && A.compare(leftChild, largest)){
            largest = leftChild;
        }
        if(rightChild < h && A.compare(rightChild, largest)){
            largest = rightChild;
        }
        if(largest != i){
            A.swap(i, largest);
            heapify(A, largest, h);
        }
    }

    private static void createHeap(Array A) {
        int n = A.length();
        for(int i = n/2 - 1; i >= 0; i--){
            heapify(A, i, n);
        }
    }

    public void sort(Array A) {
        int n = A.length();
        createHeap(A);
        for(int i = n - 1; i > 0; i--){
            A.swap(0, i);
            heapify(A, 0, i);
        }
    }

}

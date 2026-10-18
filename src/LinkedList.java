import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LinkedList {
    public ListNode head=null;

    public LinkedList(ListNode head) {
        this.head=head;
    }

    public LinkedList(int n, int seed) {
        ArrayList<Integer> x=new ArrayList<>(n);
        for (int i=0; i<n; i++) x.add(i);
        Collections.shuffle(x, new Random(seed));
        ListNode y = this.head = new ListNode(x.getFirst());
        for (int i=1; i<n; i++) {
            y.next = new ListNode(x.get(i));
            y = y.next;
        }
    }

    public int length() {
        int n=0;
        ListNode y = head;
        while (y!=null) {
            n++;
            y = y.next;
        }
        return n;
    }

    private void print() {
        ListNode y = this.head;
        while (y!=null) {
            y.print();
            y = y.next;
        }
        System.out.println();
    }

    private void sort(SortingAlgorithm<LinkedList> algorithm) {
        print();
        algorithm.sort(this);
        print();
    }

    public static void main(String[] args) {
        int n=10, seed=42;
        SortingAlgorithm[] algorithms = {
                new BubbleSort<LinkedList>(),
                new SelectionSort<LinkedList>(),
                new MergeSort()
        };
        for (SortingAlgorithm algorithm : algorithms) {
            System.out.println(algorithm.getClass().getSimpleName());
            new LinkedList(n, seed).sort(algorithm);
            System.out.println();
        }
    }
}

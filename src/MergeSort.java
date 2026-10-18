public class MergeSort implements SortingAlgorithm<LinkedList> {
    private static LinkedList split(LinkedList L, int i) {
        ListNode curr = L.head;
        for (int k = 0; k < i - 1; k++) {
            curr = curr.next;
        }
        ListNode secondHead = curr.next;
        curr.next = null;
        return new LinkedList(secondHead);
    }

    private static void merge(LinkedList L1, LinkedList L2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode a = L1.head;
        ListNode b = L2.head;

        while(a != null && b != null){
            if (a.compare(b)) {
                tail.next = b;
                b = b.next;
            } else {
                tail.next = a;
                a = a.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        L1.head = dummy.next;
    }

    public static void mergesort(LinkedList L1, int n) {
        if (n <= 1) return;
        int mid = n / 2;
        LinkedList L2 = split(L1, mid);
        mergesort(L1, mid);
        mergesort(L2, n - mid);
        merge(L1, L2);
    }

    public void sort(LinkedList L) {mergesort(L, L.length());}

}

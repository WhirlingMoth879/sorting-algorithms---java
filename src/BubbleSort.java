public class BubbleSort<T> implements SortingAlgorithm<T> {

    public void sort(Array A) {
        for(int i = 0; i < A.length() - 1; i++){
            for(int j = 0; j < A.length() - i - 1; j++){
                if(A.compare(j, j+1)) {
                    A.swap(j,j+1);
                }
            }
        }
    }

    public void sort(LinkedList L) {
        boolean swapped;
        do {
            swapped = false;
            ListNode dummy = new ListNode(0);
            dummy.next = L.head;
            ListNode prev = dummy;
            ListNode curr = L.head;

            while (curr != null && curr.next != null) {
                ListNode nextNode = curr.next;
                if (curr.compare(nextNode)) {
                    curr.next = nextNode.next;
                    nextNode.next = curr;
                    prev.next = nextNode;
                    swapped = true;
                    prev = nextNode;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
            L.head = dummy.next;
        } while (swapped);
    }

    public void sort(T A) {
        if (A instanceof Array) {
            sort((Array) A);
        }
        else if (A instanceof LinkedList) {
            sort((LinkedList) A);
        }
        else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}

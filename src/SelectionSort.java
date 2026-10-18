public class SelectionSort<T> implements SortingAlgorithm<T> {

    public void sort(Array A)
    {
        for(int i = 0; i < A.length(); i++){
            int min = i;
            for(int j = i+1; j < A.length(); j++){
                if(A.compare(min,j)){
                    A.swap(min,j);
                }
            }
        }
    }

    public void sort(LinkedList L) {
        ListNode dummy = new ListNode(0);
        dummy.next = L.head;
        ListNode sortedTail = dummy;
        while (sortedTail.next != null && sortedTail.next.next != null) {
            ListNode prevMin = sortedTail;
            ListNode minNode = sortedTail.next;
            ListNode prev = sortedTail.next;
            ListNode curr = sortedTail.next.next;

            while (curr != null) {
                if (minNode.compare(curr)) {
                    prevMin = prev;
                    minNode = curr;
                }
                prev = curr;
                curr = curr.next;
            }
            if (minNode != sortedTail.next) {
                prevMin.next = minNode.next;
                minNode.next = sortedTail.next;
                sortedTail.next = minNode;
            }
            sortedTail = minNode;
        }
        L.head = dummy.next;
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

public class ListNode {
    public ListNode(int key) {
        this.key = key;
    }
    private final int key;
    public ListNode next = null;

    public boolean compare(ListNode node) {
        return this.key > node.key;
    }

    public void print() {
        System.out.print(key+" ");
    }
}

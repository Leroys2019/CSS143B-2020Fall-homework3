package Problem2;

// all functions assume using dummy node
public class SingleLinkedList {
    // do not add member variables
    private ListNode head;
    private int size;

    public SingleLinkedList() {
        head = new ListNode();  // dummy node
    }

    // copy constructor
    public SingleLinkedList(SingleLinkedList list) {//creates the link list
        // homework
        if(list == null){
            return;
        }

        ListNode h1 = new ListNode();
        head = h1;
        ListNode h2 = list.head.next;

        while(h2 != null){
            h1.next = new ListNode(h2.val);
            h1 = h1.next;
            h2 = h2.next;
        }
        size = list.size;
    }
    public int removeAll(int valueToRemove) {
        // homework
        // in-place
        int count = 0;
        ListNode h1 = head;
        ListNode h2 = head.next;
        if(h1.next == null){
            return 0;
        }
        while(h2 != null){
            int current = h2.val;
            if(current == valueToRemove){
                h1.next = h2.next;
                size--;
                count++;
            }
            if(h2.next != null && current != valueToRemove) {
                h1 = h2;
                h2 = h2.next;
            } else if(current == valueToRemove){
                h2 = h2.next;
            } else {
                h2 = null;
            }
        }
        return count;
    }

    // reverse the linked list nodes iteratively (no recursion)
    public void reverse() {
        // homework
        // in-place
        if(head.next == null || head.next.next == null){
            return;
        }
        ListNode h1 = head.next;
        ListNode h2 = head.next.next;
        while(h2 != null){
            h1.next = h2.next;
            h2.next = head.next;
            head.next = h2;
            h2 = h1.next;
        }
    }

    // do not change any function below
    public SingleLinkedList(int[] data) {
        this();
        if (data == null) {
            return;
        }
        ListNode ptr = head;
        for (int datum : data) {
            ptr.next = new ListNode(datum);
            ptr = ptr.next;
            size++;
        }
    }
    // Appends the specified element to the end of this list
    public void add(int val) {
        size++;
        ListNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new ListNode(val);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode ptr = head.next;
        while (ptr != null) {
            builder.append(ptr.val).append(ptr.next == null ? " -> end " : " -> ");
            ptr = ptr.next;
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof SingleLinkedList)) {
            return false;
        }
        SingleLinkedList otherList = (SingleLinkedList) obj;

        if (this.size != otherList.size) {
            return false;
        }
        ListNode n1 = head.next;
        ListNode n2 = otherList.head.next;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return (n1 == null && n2 == null);
    }
    public int getSize() {
        return size;
    }
}

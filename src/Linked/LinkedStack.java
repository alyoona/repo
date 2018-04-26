package Linked;

/**
 * Created by dp-ptcstd-15 on 4/24/2018.
 */
public class LinkedStack {

    Node last;


    public void push(Object value) {
        Node newNode = new Node(value);
        if (last == null) {
            last = newNode;
            last.next = null;

        } else {
            Node current = last;
            last.next = null;
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
    }

    public Object pop() {
        return null;
    }


}

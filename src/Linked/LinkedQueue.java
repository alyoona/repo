package Linked;

/**
 * Created by dp-ptcstd-15 on 4/24/2018.
 */
public class LinkedQueue {

        Node head;

        public void enqueue(Object value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }

                current.next = newNode;
            }
        }

        public Object dequeue() {
            Object valueToReturn = head.value;
            head = head.next;
            return valueToReturn;
        }

    }


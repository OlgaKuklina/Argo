package ok.lab.com;

public class MyLinkedList {
    Node head;

    int numberOfElements;

    public Node getHead() {
        return head;
    }
    public int isCycled(Node head) {

        if(head == null || head.next == null) {
            return 0;
        }
        int a=0;
        Node pointer1 = head;
        Node pointer2 = head;
        while(pointer1 != null && pointer1.next!=null && pointer1 != pointer2) {
            pointer1 = pointer1.next.next;
            pointer2 = pointer2.next;
        }
        if(pointer1 == null || pointer1.next == null) {
            return 0;
        }
        pointer1 = head;

        while (pointer1 != pointer2){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
            a++;
        }
        return a;

    }

    public void reverse() {
        Node nodeTemp = null;
        while (head != null) {
            Node nodeTemp2 = head.next;
            Node nodeTemp3 = head;
            nodeTemp3.next = nodeTemp;
            nodeTemp = nodeTemp3;
            head = nodeTemp2;
        }
        head = nodeTemp;
    }
    public void delete(int pos) {
        Node nodeTemp2 = head;
        Node nodeTemp = head;
        if(numberOfElements < pos) {
            return;
        }
        if(pos == 0) {
            head = head.next;
        }
        else {
            while(pos != 0) {
             nodeTemp2 = nodeTemp;
             nodeTemp = nodeTemp.next;
             pos--;
            }
            nodeTemp2.next = nodeTemp.next;

        }
        numberOfElements = numberOfElements-1;
    }

    public void add(Node node, int pos) {
        Node nodeTemp2 = head;
        if(numberOfElements < pos) {
            return;
        }

        else {
            if(pos == 0) {
                Node nodetemp = head;
                head = node;
                head.next = nodetemp;
            }

            else {
                Node nodetemp = head;
                while(pos !=0) {
                    nodeTemp2 = nodetemp;
                    nodetemp = nodetemp.next;
                    pos--;
                }
                nodeTemp2.next = node;
                node.next = nodetemp;
            }
        }
        numberOfElements = numberOfElements+1;
    }
    public int numberOfElements() {
        return numberOfElements;
    }
    public static class Node {
        char data;
        Node next;
    }
}

static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

    DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

    if (head == null) {
        return newNode;
    }

    if (data < head.data) {
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

    DoublyLinkedListNode temp = head;

    while (temp.next != null && temp.next.data < data) {
        temp = temp.next;
    }

    newNode.next = temp.next;

    if (temp.next != null) {
        temp.next.prev = newNode;
    }

    temp.next = newNode;
    newNode.prev = temp;

    return head;
}